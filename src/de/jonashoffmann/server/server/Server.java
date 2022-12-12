package de.jonashoffmann.server.server;

import de.jonashoffmann.server.utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private ServerSocket serverSocket;
    private ClientHandler clientHandler;
    private int port;

    public Server(int port) {
        this.port = port;

        try {
            this.serverSocket = new ServerSocket(this.port);
            Logger.sendLogMessage("Der Server wurde gestartet!");
            this.clientHandler = new ClientHandler(this.serverSocket);
            new Thread(() -> clientHandler.accept()).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
