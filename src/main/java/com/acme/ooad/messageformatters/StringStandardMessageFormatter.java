package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.StringMessage;
import com.acme.ooad.messages.Message;
import static com.acme.ooad.messageformatters.TypeSpecifications.STRING_PREFIX;

public class StringStandardMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        return STRING_PREFIX + ((StringMessage)message).getValue() + ((StringMessage) message).getPostfix();
    }
}
