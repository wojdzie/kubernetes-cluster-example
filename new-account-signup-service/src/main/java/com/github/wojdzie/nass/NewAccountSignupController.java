package com.github.wojdzie.nass;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/signup")
class NewAccountSignupController {

    private final NewAccountSignupEventProducer producer;

    NewAccountSignupController(NewAccountSignupEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    void createNewAccountSignupEvent(@RequestBody NewAccountSignupEvent event) {
        producer.send(event);
    }


}
