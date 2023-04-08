package com.github.wojdzie.prs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class PasswordResetEventProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(PasswordResetEventProducer.class);
    private final KafkaProperties kafkaProperties;

    private final KafkaTemplate<String, PasswordResetEvent> kafkaTemplate;

    PasswordResetEventProducer(KafkaProperties kafkaProperties, KafkaTemplate<String, PasswordResetEvent> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    void send(PasswordResetEvent event) {
        LOGGER.info("Message sent: {}", event);
        kafkaTemplate.send(kafkaProperties.topic(), event);
    }
}
