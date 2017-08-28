package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.StringMessage;
import com.acme.ooad.messages.Message;

import static com.acme.ooad.messageformatters.TypeSpecifications.PRIMITIVE_PREFIX;
import static com.acme.ooad.messageformatters.TypeSpecifications.STRING_PREFIX;

public class StringStandardMessageFormatter implements MessageFormatter {

    @Override
    public String messageFormat(Message message) {
        return STRING_PREFIX + ((StringMessage)message).getValue();
    }
}
