package de.jonashoffmann.server.server;

import de.jonashoffmann.server.utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler extends Thread{

    private ServerSocket serverSocket;
    private List<Client> clientList;

    public ClientHandler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.clientList = new ArrayList<>();
    }

    public void accept() {
        while (true) {
            try {
                Logger.sendLogMessage("Der ClientHandler akzeptiert nun Clients...");
                Client client = new Client(serverSocket.accept());
                clientList.add(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        super.run();
        accept();
    }
}
