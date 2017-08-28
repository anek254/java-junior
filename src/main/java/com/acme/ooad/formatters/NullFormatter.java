package com.acme.ooad.formatters;

public class NullFormatter implements Formatter {
    @Override
    public String format(String string) {
        return string;
    }
}
