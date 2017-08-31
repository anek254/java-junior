package com.acme.ooad.messages;

import static com.acme.ooad.messages.TypeSpecifications.ARRAY_PREFIX;

public class ArrayMessage implements Message {
    private int[] value;

    public ArrayMessage(int[] value) {
        this.value = value;
    }

    public int[] getValue() {
        return value;
    }

    @Override
    public String messageToString() {
        return ARRAY_PREFIX + arrayToString(value);
    }

    private static String arrayToString(int[] a) {
        int iMax = a.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    @Override
    public void updateMessage(Object message, FormattingSavingHandler logger) {
        logger.log();
        logger.setCurrentMessage(message);
    }
}
