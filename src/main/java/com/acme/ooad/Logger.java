package com.acme.ooad;

import com.acme.ooad.formatters.Formatter;
import com.acme.ooad.formatters.NullFormatter;
import com.acme.ooad.messages.Message;
import com.acme.ooad.savers.Saver;

public class Logger {
    private Message currentMessage;
    private Saver saver;
    private Formatter formatter;

    public Logger(Saver saver) {
        this.saver = saver;
        this.formatter = new NullFormatter();
    }

    public Logger(Saver saver, Formatter formatter) {
        this.saver = saver;
        this.formatter = formatter;
    }

    public Message getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(Message message) {
        this.currentMessage = message;
    }

    public void log() {
        if (currentMessage == null) return;
        saver.save(formatter.format(currentMessage.messageToString()));
        currentMessage = null;
    }

    public void log(Message message) {
        if (message == null) return;
        saver.save(formatter.format(message.messageToString()));
    }

    public void updateMessage(Object message) {
        currentMessage.updateMessage(message, this);
    }
}
