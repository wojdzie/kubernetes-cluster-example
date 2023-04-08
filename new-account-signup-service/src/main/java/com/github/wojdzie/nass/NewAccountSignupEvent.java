package com.github.wojdzie.nass;

record NewAccountSignupEvent(String eventType, String email, String topic, String message) {

    @Override
    public String toString() {
        return "NewAccountSignupEvent{" +
                "eventType='" + eventType + '\'' +
                ", email='" + email + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
