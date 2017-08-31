package com.acme.ooad.messages;

import com.acme.ooad.FormattingSavingHandler;

import static com.acme.ooad.messages.TypeSpecifications.CHAR_PREFIX;

public class CharMessage implements Message {
    private char value;

    public CharMessage(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return CHAR_PREFIX + value;
    }

    @Override
    public void updateMessage(Object message, FormattingSavingHandler logger) {
        logger.log();
        logger.setCurrentMessage(message);
    }
}
