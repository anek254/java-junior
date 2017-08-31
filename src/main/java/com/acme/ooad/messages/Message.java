package com.acme.ooad.messages;

import com.acme.ooad.FormattingSavingHandler;

public interface Message {
    String messageToString();

    void updateMessage(Object message, FormattingSavingHandler logger);
}
