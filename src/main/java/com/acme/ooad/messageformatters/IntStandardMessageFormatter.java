package com.acme.ooad.messageformatters;
import com.acme.ooad.messages.IntMessage;
import com.acme.ooad.messages.Message;
import static com.acme.ooad.messageformatters.TypeSpecifications.PRIMITIVE_PREFIX;

public class IntStandardMessageFormatter implements MessageFormatter {

    @Override
    public String messageFormat(Message message) {
        return PRIMITIVE_PREFIX + ((IntMessage)message).getValue();
    }
}
