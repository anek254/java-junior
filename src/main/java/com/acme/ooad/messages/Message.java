package com.acme.ooad.messages;

import com.acme.ooad.Logger;

public interface Message {
    String messageToString();

    void updateMessage(Object message, Logger logger);
}
