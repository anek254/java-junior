package com.acme.ooad.messages;

import com.acme.ooad.Logger;

import static com.acme.ooad.messages.TypeSpecifications.OBJECT_PREFIX;

public class ObjectMessage implements Message {
    private Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return OBJECT_PREFIX + value;
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
