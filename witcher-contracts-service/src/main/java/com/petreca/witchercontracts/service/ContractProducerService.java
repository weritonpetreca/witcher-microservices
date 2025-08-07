package com.petreca.witchercontracts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContractProducerService {

    private static final String TOPIC = "witcher-contracts-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendContractMessage(ContractMessageDTO contractMessage) {
        this.kafkaTemplate.send(TOPIC, contractMessage);
        System.out.println("Mensagem enviada para o tópico Kafka: " + contractMessage);
    }
}
