package com.acme.ooad;

public class ObjectMessage implements Message {
    private Object value;


    @Override
    public String messageToString() {
        return "reference: " + value;
    }
}
