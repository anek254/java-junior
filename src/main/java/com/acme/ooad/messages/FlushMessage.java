package com.acme.ooad.messages;

import java.io.Serializable;

public class FlushMessage implements Message, Serializable {

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
