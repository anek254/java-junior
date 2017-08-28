package com.acme.ooad.messages;

import com.acme.ooad.Logger;
import com.acme.ooad.messageformatters.MessageFormatter;

import static com.acme.ooad.messageformatters.TypeSpecifications.PRIMITIVE_PREFIX;

public class ByteMessage implements Message {
    private byte value;
    private MessageFormatter messageFormatter;

    public ByteMessage(byte value, MessageFormatter messageFormatter) {
        this.value = value;
        this.messageFormatter = messageFormatter;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    @Override
    public String messageToString() {
        return messageFormatter.messageFormat(this);
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
        logger.log(new ByteMessage(limit, messageFormatter));
        value = (byte)(sum % limit);
    }
}
