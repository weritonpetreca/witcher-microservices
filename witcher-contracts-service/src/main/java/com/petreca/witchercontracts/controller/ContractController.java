package com.petreca.witchercontracts.controller;


import com.petreca.witchercontracts.client.ItemClient;
import com.petreca.witchercontracts.client.ItemDTO;
import com.petreca.witchercontracts.service.ContractMessageDTO;
import com.petreca.witchercontracts.service.ContractProducerService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContractController {

    private static final Logger log = LoggerFactory.getLogger(ContractController.class);

    private final ItemClient itemClient;
    private final ContractProducerService producerService;

    @PostMapping
    public ResponseEntity<String> createContract(@RequestBody ContractRequestDTO request) {
        try {
            // 1. Validate all required items by calling the other microservice
            for (Long itemId : request.getRequiredItemIds()) { // This is now safe due to initialization in DTO
                log.info("Verificando item com ID: {}", itemId);
                ItemDTO item = itemClient.findItemById(itemId);
                if (item == null) {
                    // This is a defensive check in case the Feign client is configured
                    // to not throw an exception on 404, which would be unusual.
                    throw new IllegalStateException("O serviço de itens retornou uma resposta inesperada (nula) para o item ID: " + itemId);
                }
            }

            // 2. If all items are valid, create and send the contract message to Kafka
            log.info("Todos os itens foram validados. Enviando contrato para o Kafka.");
            ContractMessageDTO message = new ContractMessageDTO(request.getMonsterName(), request.getRequiredItemIds());
            producerService.sendContractMessage(message);

            // 3. Return a success response
            return ResponseEntity.ok("Contrato para caçar "
                    + request.getMonsterName() + " aceito e registrado!");

        } catch (FeignException.NotFound e) {
            // This is an expected business error: one of the items does not exist.
            log.warn("Falha na validação de negócio: Item não encontrado. Request: {}", request);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro de validação: Um ou mais itens requeridos não foram encontrados no bestiário/arsenal.");
        } catch (FeignException e) {
            // This handles other communication errors, like the service being unavailable or returning a 5xx error.
            log.error("Erro de comunicação com o serviço de itens. Request: {}", request, e);
            return ResponseEntity
                    .status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Erro de comunicação: O serviço de itens está temporariamente indisponível. Por favor, tente novamente mais tarde.");
        } catch (Exception e) {
            // This is a catch-all for any other unexpected errors, such as problems sending the message to Kafka
            // or a NullPointerException if the request is malformed.
            log.error("Ocorreu um erro interno inesperado ao processar o contrato. Request: {}", request, e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro interno inesperado ao processar o contrato. Verifique os logs do servidor para mais detalhes.");
        }
    }
}
