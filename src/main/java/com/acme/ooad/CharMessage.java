package com.acme.ooad;

public class CharMessage implements Message {
    private char value;

    public CharMessage(char value) {
        this.value = value;
    }


    @Override
    public String messageToString() {
        return "char: " + value;
    }
}
