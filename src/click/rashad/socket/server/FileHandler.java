package io.github.rashadansari.socket.server;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileHandler {

    private PrintWriter printWriter;

    public FileHandler(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            this.printWriter = new PrintWriter(fileWriter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void append(String url, int status) {
        printWriter.println(url + "," + status);
        printWriter.flush();
    }

}
