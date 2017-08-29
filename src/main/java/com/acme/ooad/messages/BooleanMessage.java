package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

public class BooleanMessage implements Message {
    private boolean value;
    private MessageFormatter messageFormatter;

    public BooleanMessage(boolean value, MessageFormatter messageFormatter) {
        this.value = value;
        this.messageFormatter = messageFormatter;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.formatMessage(this);
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
