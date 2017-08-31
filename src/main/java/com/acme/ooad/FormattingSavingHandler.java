package com.acme.ooad;

import com.acme.ooad.formatters.Formatter;
import com.acme.ooad.formatters.NullFormatter;
import com.acme.ooad.messages.*;
import com.acme.ooad.savers.Saver;

public class FormattingSavingHandler implements EventHandler, Flushable {
    private Message currentMessage;
    private Saver saver;
    private Formatter formatter;

    public FormattingSavingHandler(Saver saver) {
        this.saver = saver;
        this.formatter = new NullFormatter();
    }

    public FormattingSavingHandler(Saver saver, Formatter formatter) {
        this.saver = saver;
        this.formatter = formatter;
    }

    public Message getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(Object message) {
        if (message instanceof Integer) {
            currentMessage = new IntMessage((Integer)message);
        } else if (message instanceof Byte) {
            currentMessage = new ByteMessage((Byte)message);
        } else if (message instanceof String) {
            currentMessage = new StringMessage((String)message);
        } else if (message instanceof Character) {
            currentMessage = new CharMessage((Character)message);
        } else if (message instanceof Boolean) {
            currentMessage = new BooleanMessage((Boolean) message);
        } else if (message instanceof int[]) {
            currentMessage = new ArrayMessage((int[])message);
        } else {
            currentMessage = new ObjectMessage(message);
        }
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

    @Override
    public void handleEvent(Object message) {
        if (message == null) return;
        if (currentMessage == null) {
            setCurrentMessage(message);
        } else {
            currentMessage.updateMessage(message, this);
        }

//        if (message instanceof String && message == "") return;

//        if (currentMessage == null) {
//            currentMessage = MessageWrapper.wrapInMessage(message);
//        } else {
//            currentMessage.updateMessage(message, this);
//        }
    }

    @Override
    public void flush() {
        log();
    }
}
