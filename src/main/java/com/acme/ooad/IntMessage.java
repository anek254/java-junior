package com.acme.ooad;

public class IntMessage implements Message {

    private int value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return "primitive: " + value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
