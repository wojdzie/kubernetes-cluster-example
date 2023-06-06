package com.github.wojdzie.nass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class NewAccountSignupEventSerializer implements Serializer<NewAccountSignupEvent> {

    @Override
    public byte[] serialize(String topic, NewAccountSignupEvent data) {
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
