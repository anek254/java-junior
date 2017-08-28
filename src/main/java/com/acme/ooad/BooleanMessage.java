package com.acme.ooad;

public class BooleanMessage implements Message {
    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }


    @Override
    public String messageToString() {
        return "primitive: " + value;
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
