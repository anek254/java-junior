package com.acme.edu;

import com.acme.ooad.*;

public class Logger {
    private static com.acme.ooad.Logger logger;

    static {
        logger = new com.acme.ooad.Logger(new ConsoleSaver());
    }

    public static void log(Object message) {
        if (isNull(message)) return;

        logger.log();
        logger.setCurrentMessage(new ObjectMessage(message));
    }

    public static void log(int[] message) {
        if (isNull(message)) return;

        logger.log();
        logger.setCurrentMessage(new ArrayMessage(message));
    }

    public static void log(int message) {
        Message currentMessage = logger.getCurrentMessage();

        if (currentMessage instanceof IntMessage) {
            logger.updateMessage(message);
        } else {
            logger.log();
            logger.setCurrentMessage(new IntMessage(message));
        }
    }

    public static void log(boolean message) {
        logger.log();
        logger.setCurrentMessage(new BooleanMessage(message));
    }

    public static void log(String message) {
        if (isNull(message)) return;
        if ("".equals(message)) return;

        Message currentMessage = logger.getCurrentMessage();

        if (currentMessage instanceof StringMessage) {
            logger.updateMessage(message);
        } else {
            logger.log();
            logger.setCurrentMessage(new StringMessage(message));
        }
    }

    public static void log(char message) {
        logger.log();
        logger.setCurrentMessage(new CharMessage(message));
    }

    public static void log(byte message) {
        Message currentMessage = logger.getCurrentMessage();

        if (currentMessage instanceof ByteMessage) {
            logger.updateMessage(message);
        } else {
            logger.log();
            logger.setCurrentMessage(new ByteMessage(message));
        }
    }

    public static void cachePrint() {
        logger.log();
    }

    private static boolean isNull(Object message) {
        return message == null;
    }

    public static void main(String[] args) {
        Logger.log(new int[] {-1, 0, 1});
        Logger.cachePrint();
    }
}
