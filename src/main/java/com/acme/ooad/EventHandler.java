package com.acme.ooad;

@FunctionalInterface
public interface EventHandler {
    void handleEvent(Object message);
}
