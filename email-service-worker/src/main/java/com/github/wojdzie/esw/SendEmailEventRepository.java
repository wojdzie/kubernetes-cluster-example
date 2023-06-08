package com.github.wojdzie.esw;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class SendEmailEventRepository {

    private final List<SendEmailEvent> events = new ArrayList<>();

    void addEvent(SendEmailEvent event) {
        events.add(event);
    }

    List<SendEmailEvent> getEvents() {
        return events;
    }

    void clear() {
        events.clear();
    }
}
