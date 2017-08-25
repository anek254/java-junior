package com.acme.ooad;

public class ArrayMessage implements Message {
    private int[] value;


    @Override
    public String messageToString() {
        return "primitives array: " + arrayToString(value);
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
