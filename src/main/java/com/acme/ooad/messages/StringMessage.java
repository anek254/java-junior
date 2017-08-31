package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import static com.acme.ooad.messages.TypeSpecifications.STRING_PREFIX;

public class StringMessage implements Message {
    private String value;
    private int equalStringCount;

    public StringMessage(String value) {
        this.value = value;
        this.equalStringCount = 1;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return STRING_PREFIX + value + getPostfix();
    }

    public void updateMessage(Object message, Logger logger) {
        String stringMessage = (String)message;

        if (isEqualToPrevious(stringMessage)) {
            ++equalStringCount;
        } else {
            logger.log();
            logger.setCurrentMessage(new StringMessage(stringMessage));
            equalStringCount = 1;
        }
    }

    private boolean isEqualToPrevious(String string) {
        return (value != null) && value.equals(string);
    }

    public String getPostfix() {
        return (equalStringCount > 1) ? " (x" + equalStringCount + ")" : "";
    }
}
