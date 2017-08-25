package com.acme.ooad;

public class StringMessage implements Message {
    private String value;

    public StringMessage(String value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return "string: " + value;
    }
}
