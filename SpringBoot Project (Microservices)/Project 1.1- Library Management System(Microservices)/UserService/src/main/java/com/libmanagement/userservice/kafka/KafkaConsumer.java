package com.libmanagement.userservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-topic", groupId = "user-service-group")
    public void consumeMessage(String message) {
        System.out.println("Received Kafka message: " + message);
    }
}
