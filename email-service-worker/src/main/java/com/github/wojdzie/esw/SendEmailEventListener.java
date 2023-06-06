package com.github.wojdzie.esw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
class SendEmailEventListener {

    private final Logger LOGGER = LoggerFactory.getLogger(SendEmailEventListener.class);

    @KafkaListener(topics = "${esw.kafka.topic}")
    void receive(SendEmailEvent event) {
        LOGGER.info("Message received: {}", event);
    }
}
