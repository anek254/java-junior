package com.acme.ooad;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

public class Logger {
    private List<EventHandler> handlers = new ArrayList<>();

    public Logger(EventHandler... eventHandlers) {
        this.handlers.addAll(asList(eventHandlers));
    }

    public void logEvent(Object message) {
        handlers.forEach(element -> element.handleEvent(message));
    }

//    public void flush() {
//        handlers.forEach(element -> element.flush());
//    }
}
