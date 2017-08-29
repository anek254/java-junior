package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.ByteMessage;
import com.acme.ooad.messages.Message;
import static com.acme.ooad.messageformatters.TypeSpecifications.PRIMITIVE_PREFIX;

public class ByteStandardMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        return PRIMITIVE_PREFIX + ((ByteMessage)message).getValue();
    }
}
