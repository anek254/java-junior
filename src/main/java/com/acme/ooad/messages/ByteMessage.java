package com.acme.ooad.messages;

import com.acme.ooad.FormattingSavingHandler;

import static com.acme.ooad.messages.TypeSpecifications.PRIMITIVE_PREFIX;

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
        return PRIMITIVE_PREFIX + value;
    }

    public void updateMessage(Object message, FormattingSavingHandler logger) {
        if (message instanceof Byte) {
            sumWithOverflowCheck((Byte) message, logger);
        } else {
            logger.log();
            logger.setCurrentMessage(message);
        }
    }

    private void sumWithOverflowCheck(byte message, FormattingSavingHandler logger) {
        int sum = (int) value + message;

        if (sum > Byte.MAX_VALUE) {
            printAndUpdateWhenOverflow(sum, Byte.MAX_VALUE, logger);
        } else if (sum < Byte.MIN_VALUE) {
            printAndUpdateWhenOverflow(sum, Byte.MIN_VALUE, logger);
        } else {
            value += message;
        }
    }

    private void printAndUpdateWhenOverflow(int sum, byte limit, FormattingSavingHandler logger) {
        logger.log(new ByteMessage(limit));
        value = (byte) (sum % limit);
    }
}
