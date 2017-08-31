package com.acme.ooad.messages;

import static com.acme.ooad.messages.TypeSpecifications.PRIMITIVE_PREFIX;

public class BooleanMessage implements Message {
    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return PRIMITIVE_PREFIX + value;
    }

    @Override
    public void updateMessage(Object message, FormattingSavingHandler logger) {
        logger.log();
        logger.setCurrentMessage(message);
    }
}
