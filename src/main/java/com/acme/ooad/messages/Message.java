package com.acme.ooad.messages;

public interface Message {
    String messageToString();

    void updateMessage(Object message, FormattingSavingHandler logger);
}
