package com.acme.ooad;

public class ByteMessage implements Message {
    private byte value;


    @Override
    public String messageToString() {
        return "primitive: " + value;
    }
}
