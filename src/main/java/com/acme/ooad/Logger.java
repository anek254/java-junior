package com.acme.ooad;

public class Logger {
    private Message currentMessage;

    public Message getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;
    }

    public void updateIntMessage(int message) {
        int value = ((IntMessage)currentMessage).getValue();

        if (value + message > (long) Integer.MAX_VALUE) {
            System.out.println("primitive: " + Integer.MAX_VALUE);
            value = (message + value) % Integer.MAX_VALUE;
        } else if (value + message < (long) Integer.MIN_VALUE) {
            System.out.println("primitive: " + Integer.MIN_VALUE);
            value = (message + value) % Integer.MIN_VALUE;
        } else {
            value += message;
        }

        ((IntMessage)currentMessage).setValue(value);
    }

    public void log() {
        if (currentMessage == null) return;
        System.out.println(currentMessage.messageToString());
    }
}
