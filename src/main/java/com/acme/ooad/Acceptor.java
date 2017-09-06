package com.acme.ooad;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Acceptor {
    private ServerSocket serverSocket;

    public Acceptor(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void acceptAll() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ConnectionHandler(clientSocket)).start();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Acceptor acceptor = new Acceptor(7777);
        acceptor.acceptAll();
    }
}
