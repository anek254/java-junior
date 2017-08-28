package com.acme.ooad;

public class IntMessage implements Message {
    private int value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return "primitive: " + value;
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
        logger.log(new IntMessage(limit));
        value = (int)(sum % limit);
    }
}
