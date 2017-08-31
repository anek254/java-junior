package com.acme.ooad.messages;

public class FlushMessage implements Message {

    @Override
    public String messageToString() {
        return null;
    }

    @Override
    public void updateMessage(Object message, FormattingSavingHandler logger) {
        logger.log();
        logger.setCurrentMessage(message);
    }

    @Override
    public String toString() {
        return "";
    }
}
