package de.jonashoffmann.server.main.init;

import de.jonashoffmann.server.server.Server;

public class Initializer {

    private Server server;

    public Initializer() {
        this.server = new Server(1234);

    }

}
