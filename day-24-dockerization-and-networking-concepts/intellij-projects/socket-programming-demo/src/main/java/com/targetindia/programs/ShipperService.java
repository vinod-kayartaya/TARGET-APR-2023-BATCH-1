package com.targetindia.programs;

import com.targetindia.service.ClientHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class ShipperService {
    @SneakyThrows
    public static void main(String[] args) {
        try (
                ServerSocket server = new ServerSocket(8080)
        ) {
            log.trace("server started");

            while(true){
                log.trace("waiting for a client request...");
                Socket client = server.accept();
                // create a new thread that can handle/process this client's request
                new Thread(new ClientHandler(client)).start();
            }
        }
    }
}
