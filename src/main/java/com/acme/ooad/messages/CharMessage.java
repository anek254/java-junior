package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

public class CharMessage implements Message {
    private char value;
    private MessageFormatter messageFormatter;

    public CharMessage(char value, MessageFormatter messageFormatter) {
        this.value = value;
        this.messageFormatter = messageFormatter;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.formatMessage(this);
    }

    @Override
    public void updateMessage(Object message, Logger logger) {}
}
