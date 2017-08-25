package com.acme.ooad;

public class CharMessage implements Message {
    private char value;


    @Override
    public String messageToString() {
        return "char: " + value;
    }
}
