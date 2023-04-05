package com.github.wojdzie.prs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "prs.kafka")
record KafkaProperties(String topic) {
}
