package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.ObjectMessage;
import com.acme.ooad.messages.Message;
import static com.acme.ooad.messageformatters.TypeSpecifications.OBJECT_PREFIX;

public class ObjectStandardMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        return OBJECT_PREFIX + ((ObjectMessage)message).getValue();
    }
}
