package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

public class IntMessage implements Message {

    private int value;
    private MessageFormatter messageFormatter;

    public IntMessage(int value, MessageFormatter messageFormatter) {
        this.value = value;
        this.messageFormatter = messageFormatter;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.messageFormat(this);
    }

    public void updateMessage(Object message, Logger logger) {
        sumWithOverflowCheck((Integer)message, logger);
    }

    private void sumWithOverflowCheck(int message, Logger logger) {
        long sum = (long)value + message;

        if (sum > Integer.MAX_VALUE) {
            printAndUpdateWhenOverflow(sum, Integer.MAX_VALUE, logger);
        } else if (sum < Integer.MIN_VALUE) {
            printAndUpdateWhenOverflow(sum, Integer.MIN_VALUE, logger);
        } else {
            value += message;
        }
    }

    private void printAndUpdateWhenOverflow(long sum, int limit, Logger logger) {
        logger.log(new IntMessage(limit, messageFormatter));
        value = (int)(sum % limit);
    }
}
