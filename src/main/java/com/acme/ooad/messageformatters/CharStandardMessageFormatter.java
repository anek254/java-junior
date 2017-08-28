package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.CharMessage;
import com.acme.ooad.messages.Message;

import static com.acme.ooad.messageformatters.TypeSpecifications.CHAR_PREFIX;

public class CharStandardMessageFormatter implements MessageFormatter {

    @Override
    public String messageFormat(Message message) {
        return CHAR_PREFIX + ((CharMessage)message).getValue();
    }
}
