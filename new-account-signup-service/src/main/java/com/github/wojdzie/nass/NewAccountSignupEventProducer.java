package com.github.wojdzie.nass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class NewAccountSignupEventProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(NewAccountSignupEventProducer.class);
    private final KafkaProperties kafkaProperties;

    private final KafkaTemplate<String, NewAccountSignupEvent> kafkaTemplate;

    NewAccountSignupEventProducer(KafkaProperties kafkaProperties, KafkaTemplate<String, NewAccountSignupEvent> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    void send(NewAccountSignupEvent event) {
        LOGGER.info("Message sent: {}", event);
        kafkaTemplate.send(kafkaProperties.topic(), event);
    }
}
