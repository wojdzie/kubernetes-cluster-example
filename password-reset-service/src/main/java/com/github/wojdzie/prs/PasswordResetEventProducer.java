package com.github.wojdzie.prs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class PasswordResetEventProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(PasswordResetEventProducer.class);
    private final KafkaProperties kafkaProperties;

    private final KafkaTemplate<String, String> kafkaTemplate;

    PasswordResetEventProducer(KafkaProperties kafkaProperties, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    void send(String message) {
        LOGGER.info("Message sent: {}", message);
        kafkaTemplate.send(kafkaProperties.topic(), message);
    }
}
