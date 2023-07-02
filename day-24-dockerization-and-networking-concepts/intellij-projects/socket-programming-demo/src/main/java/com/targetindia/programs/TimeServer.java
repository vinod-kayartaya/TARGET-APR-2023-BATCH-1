package com.targetindia.programs;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {

    public static void main(String[] args) {
        System.out.println("Starting the TimeServer...");

        try (
                ServerSocket server = new ServerSocket(8080)
        ) {
            System.out.printf("Server acquired port 8080 on %s%n", server.getInetAddress());

            while(true){
                System.out.println("Waiting for a client connection...");
                Socket client = server.accept(); // wait for a client request
                System.out.printf("Client connected from %s%n", client.getInetAddress());

                // send the current time information to the client
                String time = new Date().toString();
                OutputStream outputStream = client.getOutputStream();
                PrintStream out = new PrintStream(outputStream);
                out.println(time);
                client.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
