package com.acme.ooad;


import com.acme.ooad.messages.FlushMessage;

import java.io.*;
import java.net.Socket;

public class Connector {
    private Socket socket;
    private final ObjectOutputStream out;
    

    public Connector(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendToServer(Object objectToSend) {
        try {
            out.writeObject(objectToSend);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        new Thread(() -> {
            Connector connector = new Connector("127.0.0.1", 7777);
            while (true) {
                connector.sendToServer(1);
                connector.sendToServer(5);
                connector.sendToServer(new FlushMessage());
            }
        }).start();

        new Thread(() -> {
            Connector connector = new Connector("127.0.0.1", 7777);
            while (true) {
                connector.sendToServer("str 1");
                connector.sendToServer("str 2");
                connector.sendToServer("str 2");
            }
        }).start();
    }
}
