package com.acme.ooad;

public class BooleanMessage implements Message {
    private boolean value;


    @Override
    public String messageToString() {
        return "primitive: " + value;
    }
}
