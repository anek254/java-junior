package com.acme.ooad;

public class ObjectMessage implements Message {
    private Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return "reference: " + value;
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
