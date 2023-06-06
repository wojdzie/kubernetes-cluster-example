package com.github.wojdzie.esw;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class SendEmailEventDeserializer implements Deserializer<SendEmailEvent> {

    @Override
    public SendEmailEvent deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        SendEmailEvent sendEmailEvent = null;
        try {
            sendEmailEvent = objectMapper.readValue(data, SendEmailEvent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendEmailEvent;
    }
}
