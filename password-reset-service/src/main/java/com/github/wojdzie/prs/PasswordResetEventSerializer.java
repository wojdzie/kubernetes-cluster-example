package com.github.wojdzie.prs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class PasswordResetEventSerializer implements Serializer<PasswordResetEvent> {

    @Override
    public byte[] serialize(String topic, PasswordResetEvent data) {
        byte[] value = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            value = objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
