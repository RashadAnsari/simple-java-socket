package io.github.rashadansari.socket;

import io.github.rashadansari.socket.server.Server;

public class SimpleServer {

    public static void main(String[] args) {
        System.out.println("Start server...");
        Server server = new Server(
                "127.0.0.1", 8080, "result.csv"
        );
        server.start();
    }

}
