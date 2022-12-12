package de.jonashoffmann.server.server;

import de.jonashoffmann.server.utils.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread{

    private Socket clientSocket;

    public Client(Socket clientSocket) {
        Logger.sendLogMessage("Es wurde ein neuer Client akzeptiert! -> " + clientSocket.getInetAddress());
        this.clientSocket = clientSocket;
        this.start();
    }

    @Override
    public void run() {
        readMessage();
    }

    public void sendClientMessage(String message) {

    }

    public void readMessage() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = reader.readLine();
                if(message != null) System.out.println(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
