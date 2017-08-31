package com.acme.ooad.savers;

public class ConsoleSaver implements Saver {
    @Override
    public void save(String string) {
        if (string == null) return;
        System.out.println(string);
    }
}
