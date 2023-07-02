package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.*;
import java.net.Socket;

public class HelloClient {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("192.168.1.23", 8080);
        ) {
            OutputStream outputStream = socket.getOutputStream();
            PrintStream out = new PrintStream(outputStream);
            String name = KeyboardUtil.getString("Enter your name: ");
            out.println(name); // writing to the server
            // the server will write you back
            // now we need to read the same

            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String message = in.readLine();

            System.out.printf("Server wrote: %s%n", message);

        } // socket is closed here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
