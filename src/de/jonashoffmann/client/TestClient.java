package de.jonashoffmann.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TestClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 1234);
            sendMessage(socket.getOutputStream(), "Hallo ich bin der Client\n");
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static void sendMessage(OutputStream outputStream, String message) {
        for(char chars : message.toCharArray()) {
            try {
                outputStream.write(chars);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
