package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

public class StringMessage implements Message {

    private String value;
    private int equalStringCount;
    private MessageFormatter messageFormatter;

    public StringMessage(String value, MessageFormatter messageFormatter) {
        this.value = value;
        this.equalStringCount = 1;
        this.messageFormatter = messageFormatter;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.messageFormat(this);
    }

    public void updateMessage(Object message, Logger logger) {
        String stringMessage = (String)message;

        if (isEqual(stringMessage)) {
            ++equalStringCount;
        } else {
            logger.log();
            logger.setCurrentMessage(new StringMessage(stringMessage, messageFormatter));
            equalStringCount = 1;
        }
    }

    private boolean isEqual(String string) {
        return (value != null) && value.equals(string);
    }

    private String getPostfix() {
        return (equalStringCount > 1) ? " (x" + equalStringCount + ")" : "";
    }
}
