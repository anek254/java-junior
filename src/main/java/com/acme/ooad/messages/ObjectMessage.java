package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

import static com.acme.ooad.messageformatters.TypeSpecifications.OBJECT_PREFIX;

public class ObjectMessage implements Message {
    private Object value;
    private MessageFormatter messageFormatter;

    public ObjectMessage(Object value, MessageFormatter messageFormatter) {
        this.value = value;
        this.messageFormatter = messageFormatter;
    }

    public Object getValue() {
        return value;
    }

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.messageFormat(this);
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
