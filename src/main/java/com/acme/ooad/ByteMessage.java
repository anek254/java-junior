package com.acme.ooad;

public class ByteMessage implements Message {
    private byte value;

    public ByteMessage(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return "primitive: " + value;
    }

    public void updateMessage(Object message, Logger logger) {
        sumWithOverflowCheck((Byte)message, logger);
    }

    private void sumWithOverflowCheck(byte message, Logger logger) {
        int sum = (int)value + message;

        if (sum > Byte.MAX_VALUE) {
            printAndUpdateWhenOverflow(sum, Byte.MAX_VALUE, logger);
        } else if (sum < Byte.MIN_VALUE) {
            printAndUpdateWhenOverflow(sum, Byte.MIN_VALUE, logger);
        } else {
            value += message;
        }
    }

    private void printAndUpdateWhenOverflow(int sum, byte limit, Logger logger) {
        logger.log(new ByteMessage(limit));
        value = (byte)(sum % limit);
    }
}
