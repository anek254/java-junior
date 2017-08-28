package com.acme.ooad;

public interface Message {
    String messageToString();

    void updateMessage(Object message, Logger logger);
}
