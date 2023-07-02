package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 8080);
        ) {
            System.out.println("Got a connection to the server..");
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String serverTime = in.readLine();
            System.out.println("Time from server is " + serverTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
