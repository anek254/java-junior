package com.acme.edu;

import com.acme.ooad.ConsoleEventHandler;
import com.acme.ooad.Flushable;
import com.acme.ooad.FormattingSavingHandler;
import com.acme.ooad.Logger;
import com.acme.ooad.messages.FlushMessage;
import com.acme.ooad.savers.ConsoleSaver;

public class FacadeLogger {
    private static Logger logger;

    static {
        logger = new Logger(
                new FormattingSavingHandler(new ConsoleSaver()),
                System.out::println
        );
//        logger = new FormattingSavingHandler(new ConsoleSaver());
    }
//
//    public static void log(Object message) {
//        if (isNull(message)) return;
//        logger.logEvent(new ObjectMessage(message));
//
//ß
////        if (isNull(message)) return;
////        logger.log();
////        logger.setCurrentMessage(new ObjectMessage(message));
//    }
//
//    public static void log(int[] message) {
//        if (isNull(message)) return;
//        logger.logEvent(new ArrayMessage(message));
//
////        logger.log();
////        logger.setCurrentMessage(new ArrayMessage(message));
//    }
//
//    public static void log(int message) {
//        logger.logEvent(new IntMessage(message));
//
////        Message currentMessage = logger.getCurrentMessage();
////
////        if (currentMessage instanceof IntMessage) {
////            logger.updateMessage(message);
////        } else {
////            logger.log();
////            logger.setCurrentMessage(new IntMessage(message));
////        }
//    }
//
//
//    public static void log(boolean message) {
//        logger.logEvent(new BooleanMessage(message));
////        logger.log();
////        logger.setCurrentMessage(new BooleanMessage(message));
//    }
//
//    public static void log(String message) {
//        if (isNull(message)) return;
//        if ("".equals(message)) return;
//
//        logger.logEvent(new StringMessage(message));
//
////        Message currentMessage = logger.getCurrentMessage();
////
////        if (currentMessage instanceof StringMessage) {
////            logger.updateMessage(message);
////        } else {
////            logger.log();
////            logger.setCurrentMessage(new StringMessage(message));
////        }
//    }
//
//    public static void log(char message) {
//        logger.logEvent(new CharMessage(message));
//
////        logger.log();
////        logger.setCurrentMessage(new CharMessage(message));
//    }
//
//    public static void log(byte message) {
//        logger.logEvent(new ByteMessage(message));
//
////        Message currentMessage = logger.getCurrentMessage();
////
////        if (currentMessage instanceof ByteMessage) {
////            logger.updateMessage(message);
////        } else {
////            logger.log();
////            logger.setCurrentMessage(new ByteMessage(message));
////        }
//    }
//
//    public static void cachePrint() {
//        logger.flush();
//    }

    public static void log(Object message) {
        if (isNull(message)) return;
        logger.logEvent(message);
    }

    private static boolean isNull(Object message) {
        return message == null;
    }


    public static void main(String[] args) {
        log("str1");
        log("str1");
        log("str2");
        log(4);
        log(new FlushMessage());
    }
}
