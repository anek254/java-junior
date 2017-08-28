package com.acme.ooad;

public class StringMessage implements Message {
    private String value;
    private int equalStringCount;

    public StringMessage(String value) {
        this.value = value;
        this.equalStringCount = 1;
    }

    @Override
    public String messageToString() {
        return "string: " + value + getPostfix();
    }

    public void updateMessage(Object message, Logger logger) {
        String stringMessage = (String)message;

        if (compareWithString(stringMessage)) {
            ++equalStringCount;
        } else {
            logger.log();
            logger.setCurrentMessage(new StringMessage(stringMessage));
            equalStringCount = 1;
        }
    }

    private boolean compareWithString(String string) {
        return (value != null) && value.equals(string);
    }

    private String getPostfix() {
        return (equalStringCount > 1) ? " (x" + equalStringCount + ")" : "";
    }
}
