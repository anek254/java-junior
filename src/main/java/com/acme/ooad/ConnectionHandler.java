package com.acme.ooad;

import com.acme.edu.FacadeLogger;
import com.acme.ooad.messages.FormattingSavingHandler;
import com.acme.ooad.savers.ConsoleSaver;
import com.acme.ooad.savers.Saver;

import java.io.*;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private Socket socket;
    private Logger logger;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        this.logger = new Logger(new FormattingSavingHandler(new ConsoleSaver()));
    }

    @Override
    public void run() {
        try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
            while(true) {
                logger.logEvent(input.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
