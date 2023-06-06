package com.github.wojdzie.prs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prs/password/reset")
class PasswordResetController {

    private final PasswordResetEventProducer producer;

    PasswordResetController(PasswordResetEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    void createPasswordResetEvent(@RequestBody PasswordResetEvent event) {
        producer.send(event);
    }


}
