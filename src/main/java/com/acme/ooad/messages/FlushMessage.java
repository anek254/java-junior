package com.acme.ooad.messages;

import com.acme.ooad.FormattingSavingHandler;

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
        return null;
    }
}
