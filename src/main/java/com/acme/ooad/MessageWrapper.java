package com.acme.ooad;

import com.acme.ooad.messages.*;

public class MessageWrapper {
    public static IntMessage wrapInMessage(Integer message) {
        return new IntMessage(message);
    }

    public static ByteMessage wrapInMessage(Byte message) {
        return new ByteMessage(message);
    }

    public static StringMessage wrapInMessage(String message) {
        return new StringMessage(message);
    }

    public static BooleanMessage wrapInMessage(Boolean message) {
        return new BooleanMessage(message);
    }

    public static CharMessage wrapInMessage(Character message) {
        return new CharMessage(message);
    }

//    public static ObjectMessage wrapInMessage(Object message) {
//        return new ObjectMessage(message);
//    }

    public static ArrayMessage wrapInMessage(int[] message) {
        return new ArrayMessage(message);
    }
}
