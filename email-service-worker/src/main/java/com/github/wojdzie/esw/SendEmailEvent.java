package com.github.wojdzie.esw;

record SendEmailEvent(String eventType, String email, String topic, String message) {

    @Override
    public String toString() {
        return "SendEmailEvent{" +
                "eventType='" + eventType + '\'' +
                ", email='" + email + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
