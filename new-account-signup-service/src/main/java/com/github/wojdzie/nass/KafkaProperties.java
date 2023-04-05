package com.github.wojdzie.nass;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nass.kafka")
record KafkaProperties(String topic) {
}
