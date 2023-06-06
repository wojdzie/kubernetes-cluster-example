package com.github.wojdzie.esw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/esw/event")
class SendEmailEventController {

    private final SendEmailEventRepository repository;


    SendEmailEventController(SendEmailEventRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<SendEmailEvent> getEvents() {
        return repository.getEvents();
    }

    @PostMapping
    void clearEvents() {
        repository.clear();
    }
}
