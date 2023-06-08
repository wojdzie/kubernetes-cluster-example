package com.github.wojdzie.esw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
class SendEmailEventListener {

    private final Logger LOGGER = LoggerFactory.getLogger(SendEmailEventListener.class);
    private final SendEmailEventRepository repository;

    SendEmailEventListener(SendEmailEventRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${esw.kafka.topic}")
    void receive(SendEmailEvent event) {
        repository.addEvent(event);
        LOGGER.info("Message received: {}", event);
    }
}
