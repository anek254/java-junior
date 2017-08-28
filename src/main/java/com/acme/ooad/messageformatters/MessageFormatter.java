package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.Message;

public interface MessageFormatter {
    public String messageFormat(Message message);
}
