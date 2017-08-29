package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

public class ArrayMessage implements Message {
    private int[] value;
    private MessageFormatter messageFormatter;

    public ArrayMessage(int[] value, MessageFormatter messageFormatter) {
        this.value = value;
        this.messageFormatter = messageFormatter;
    }

    public int[] getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.formatMessage(this);
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
