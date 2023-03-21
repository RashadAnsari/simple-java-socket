package io.github.rashadansari.socket.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class ClientHandler extends Thread {

    private Socket client;
    private FileHandler fileHandler;

    public ClientHandler(Socket client, FileHandler fileHandler) {
        this.client = client;
        this.fileHandler = fileHandler;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = client.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String url;
            while ((url = bufferedReader.readLine()) != null) {
                System.out.println(url);
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(3000);
                int status = connection.getResponseCode();
                fileHandler.append(url, status);
            }

            inputStreamReader.close();
            bufferedReader.close();
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
