package com.github.wojdzie.prs;

record PasswordResetEvent(String eventType, String email, String topic, String message) {

    @Override
    public String toString() {
        return "PasswordResetEvent{" +
                "eventType='" + eventType + '\'' +
                ", email='" + email + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
