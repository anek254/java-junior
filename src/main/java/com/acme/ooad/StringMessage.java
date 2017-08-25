package com.acme.ooad;

public class StringMessage implements Message {
    private String value;


    @Override
    public String messageToString() {
        return "string: " + value;
    }
}
