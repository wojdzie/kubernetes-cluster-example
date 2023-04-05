package com.github.wojdzie.nass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class NewAccountSignupEventProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(NewAccountSignupEventProducer.class);
    private final KafkaProperties kafkaProperties;

    private final KafkaTemplate<String, String> kafkaTemplate;

    NewAccountSignupEventProducer(KafkaProperties kafkaProperties, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    void send(String message) {
        LOGGER.info("Message sent: {}", message);
        kafkaTemplate.send(kafkaProperties.topic(), message);
    }
}
