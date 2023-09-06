package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;

        try (Socket clientSocker = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocker.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocker.getInputStream()))
        ) {

            System.out.println("Client connected!");

            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
