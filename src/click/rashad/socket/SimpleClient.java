package io.github.rashadansari.socket;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        try {
            Socket client = new Socket();
            client.connect(new InetSocketAddress("127.0.0.1", 8080));

            PrintWriter printWriter = new PrintWriter(client.getOutputStream());

            printWriter.println("https://google.com");
            printWriter.flush();

            printWriter.println("https://rashad.click");
            printWriter.flush();

            printWriter.close();
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
