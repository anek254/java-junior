package com.acme.ooad.messages;

import com.acme.ooad.FormattingSavingHandler;

import static com.acme.ooad.messages.TypeSpecifications.PRIMITIVE_PREFIX;

public class IntMessage implements Message {
    private int value;

    public IntMessage(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return PRIMITIVE_PREFIX + value;
    }

    public void updateMessage(Object message, FormattingSavingHandler logger) {
        if (message instanceof Integer) {
            sumWithOverflowCheck((Integer) message, logger);
        } else {
            logger.log();
            logger.setCurrentMessage(message);
        }
    }

    private void sumWithOverflowCheck(int message, FormattingSavingHandler logger) {
        long sum = (long) value + message;

        if (sum > Integer.MAX_VALUE) {
            printAndUpdateWhenOverflow(sum, Integer.MAX_VALUE, logger);
        } else if (sum < Integer.MIN_VALUE) {
            printAndUpdateWhenOverflow(sum, Integer.MIN_VALUE, logger);
        } else {
            value += message;
        }
    }

    private void printAndUpdateWhenOverflow(long sum, int limit, FormattingSavingHandler logger) {
        logger.log(new IntMessage(limit));
        value = (int) (sum % limit);
    }
}
