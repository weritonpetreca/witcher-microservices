package com.petreca.witchercontracts.service;

import com.petreca.witchercontracts.client.ItemClient;
import com.petreca.witchercontracts.dto.ContractDTO;
import com.petreca.witchercontracts.dto.CreateContractRequestDTO;
import com.petreca.witchercontracts.dto.UpdateContractStatusDTO;
import com.petreca.witchercontracts.mapper.ContractMapper;
import com.petreca.witchercontracts.model.Contract;
import com.petreca.witchercontracts.model.ContractStatus;
import com.petreca.witchercontracts.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContractService {

    private final ItemClient itemClient;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll()
                .stream()
                .map(contractMapper::toDTO)
                .toList();
    }

    public Optional<ContractDTO> getContractById(Long id) {
        return contractRepository.findById(id)
                .map(contractMapper::toDTO);
    }

    public List<ContractDTO> getContractsByStatus(ContractStatus status) {
        return contractRepository.findByStatus(status)
                .stream()
                .map(contractMapper::toDTO)
                .toList();
    }

    public ContractDTO createContract(CreateContractRequestDTO requestDTO) {
        // Validate if all required items exist
        for (Long itemId : requestDTO.getRequiredItemIds()) {
            try {
                itemClient.findItemById(itemId);
            } catch (Exception e) {
                log.error("Item with ID {} not found", itemId);
                throw new RuntimeException("Item com ID " + itemId + " não encontrado no bestiário.");
            }
        }

        Contract contract = new Contract();
        contract.setMonsterId(requestDTO.getMonsterId());
        contract.setRequiredItemIds(requestDTO.getRequiredItemIds());
        contract.setStatus(ContractStatus.PENDING);

        Contract savedContract = contractRepository.save(contract);
        
        // Send notification to Kafka
        kafkaTemplate.send("contract-events", savedContract);
        
        log.info("Contract created with ID: {}", savedContract.getId());
        return contractMapper.toDTO(savedContract);
    }

    public Optional<ContractDTO> updateContractStatus(Long id, UpdateContractStatusDTO statusDTO) {
        return contractRepository.findById(id)
                .map(contract -> {
                    contract.setStatus(statusDTO.getStatus());
                    Contract updatedContract = contractRepository.save(contract);
                    log.info("Contract {} status updated to {}", id, statusDTO.getStatus());
                    return contractMapper.toDTO(updatedContract);
                });
    }

    public boolean deleteContract(Long id) {
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
            log.info("Contract {} deleted", id);
            return true;
        }
        return false;
    }
}