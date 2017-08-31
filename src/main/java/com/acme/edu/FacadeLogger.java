package com.acme.edu;

import com.acme.ooad.FormattingSavingHandler;
import com.acme.ooad.Logger;
import com.acme.ooad.savers.ConsoleSaver;

public class FacadeLogger {
    private static Logger logger;

    static {
        logger = new Logger(
                new FormattingSavingHandler(new ConsoleSaver()),
                System.out::println
        );
    }

    public static void log(Object message) {
        if (isNull(message)) return;
        logger.logEvent(message);
    }

    private static boolean isNull(Object message) {
        return message == null;
    }
}
