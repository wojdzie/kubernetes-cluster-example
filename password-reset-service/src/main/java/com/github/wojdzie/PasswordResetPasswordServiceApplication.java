package com.github.wojdzie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.kafka.annotation.EnableKafka;

@ConfigurationPropertiesScan
@EnableKafka
@SpringBootApplication
public class PasswordResetPasswordServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordResetPasswordServiceApplication.class);
    }
}
