package io.github.rashadansari.socket.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private String host;
    private int port;
    private FileHandler fileHandler;

    public Server(String host, int port, String filename) {
        this.host = host;
        this.port = port;
        this.fileHandler = new FileHandler(filename);
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket();
            server.bind(new InetSocketAddress(host, port));
            while (true) {
                Socket client = server.accept();
                new ClientHandler(client, fileHandler).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
