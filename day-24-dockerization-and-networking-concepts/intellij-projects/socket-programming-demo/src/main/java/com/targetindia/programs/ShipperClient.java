package com.targetindia.programs;

import com.targetindia.model.Shipper;
import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipperClient {

    @SneakyThrows
    public static void main(String[] args) {

        the_loop:
        while (true) {
            System.out.println("Main menu");
            System.out.println("---------");
            System.out.println("0. Exit");
            System.out.println("1. Search shipper by id");
            System.out.println("2. Display all shippers");
            int choice = KeyboardUtil.getInt("Enter your choice: ");

            try (
                    Socket socket = new Socket("192.168.1.23", 8080)
            ) {

                Map<String, Object> request = new HashMap<>();
                switch (choice) {
                    case 0:
                        break the_loop;
                    case 1:
                        int id = KeyboardUtil.getInt("Enter shipper id: ");
                        request.put("methodName", "findById");
                        request.put("methodParams", id);
                        break;
                    case 2:
                        request.put("methodName", "findAll");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again!");
                        continue the_loop;
                }

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(outputStream);
                out.writeObject(request);

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream in = new ObjectInputStream(inputStream);

                Object response = in.readObject();
                if (response == null) {
                    System.out.println("Server didn't send any response");
                } else if (response instanceof Shipper) {
                    Shipper shipper = (Shipper) response;
                    System.out.println("Shipper data found!");
                    System.out.printf("Company name: %s%n", shipper.getName());
                    System.out.printf("Phone number: %s%n", shipper.getPhone());
                } else if (response instanceof List) {
                    List<Shipper> shippers = (List<Shipper>) response;
                    shippers.forEach(System.out::println);
                } else {
                    System.out.println(response);
                }
            }// socket.close() called here
        }
    }
}
