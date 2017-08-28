package com.acme.ooad.messageformatters;

import com.acme.ooad.messages.ArrayMessage;
import com.acme.ooad.messages.Message;

import static com.acme.ooad.messageformatters.TypeSpecifications.ARRAY_PREFIX;

public class ArrayStandardMessageFormatter implements MessageFormatter {

    @Override
    public String messageFormat(Message message) {
        return ARRAY_PREFIX + arrayToString(((ArrayMessage)message).getValue());
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
}
