package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.Message;

public interface MessageFormatter {
    String formatMessage(Message message);
}
