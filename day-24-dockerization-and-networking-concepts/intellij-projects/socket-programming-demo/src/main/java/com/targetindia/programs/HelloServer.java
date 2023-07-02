package com.targetindia.programs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("hello-server started!");
            while (true) {
                System.out.println("waiting for a client...");
                try (Socket client = server.accept()) {
                    System.out.printf("got a connection from %s%n", client.getInetAddress().getAddress().toString());
                    InputStream inputStream = client.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                    String name = in.readLine();

                    System.out.printf("Client sent their name as '%s'%n", name);

                    OutputStream outputStream = client.getOutputStream();
                    PrintStream out = new PrintStream(outputStream);
                    out.printf("Hello, %s. How are you doing today?%n", name);
                } // client.close() called here
            }
        } // server.close() called here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
