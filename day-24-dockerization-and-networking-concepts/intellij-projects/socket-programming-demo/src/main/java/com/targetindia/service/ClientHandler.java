package com.targetindia.service;

import com.targetindia.dao.ShipperDao;
import com.targetindia.model.Shipper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Slf4j
public class ClientHandler implements Runnable{

    private Socket client;

    @SneakyThrows
    @Override
    public void run() {
        log.trace("processing the request for the client at {} address", client.getInetAddress());
        InputStream inputStream = client.getInputStream();
        ObjectInputStream in = new ObjectInputStream(inputStream);
        Map<String, Object> request = (Map<String, Object>) in.readObject();

        String methodName = (String) request.get("methodName");
        ShipperDao dao = new ShipperDao();

        OutputStream outputStream = client.getOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outputStream);

        switch (methodName){
            case "findById":
                Integer shipperId = (Integer) request.get("methodParams");
                log.trace("client wants a shipper data for shipper id {}", shipperId);
                Shipper shipper = dao.findById(shipperId);
                if(shipper==null){
                    log.trace("no shipper was found for the given id");
                }
                else {
                    log.trace("shipper found for the given id: {}", shipper);
                }
                out.writeObject(shipper);
                break;
            case "findAll":
                List<Shipper> shippers = dao.findAll();
                out.writeObject(shippers);
                break;
            default:
                out.writeObject(new String("Invalid method name"));
        }
        client.close();
    }
}
