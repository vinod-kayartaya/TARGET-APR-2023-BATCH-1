package com.targetindia.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDatabaseServer {
    public static void main(String[] args) {
        // https://www.vinod.co:443/contactus
        // http://www.vinod.co:80/contactus
        // String url = "jdbc:mysql://vinod-mbp-16.local:3306/targetdb_b1"; // discriminator
        String url = "jdbc:h2:tcp://vinod-mbp-16.local/~/targetdb_b1"; // discriminator
        // String url = "jdbc:sqlite:targetdb_b1.sqlite"; // discriminator
        // String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // discriminator
        String user = "root";
        String password = "Welcome#123";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
        ) {
            System.out.printf("got a connection of type: %s%n", conn.getClass().getName());
        } // conn.close() is automatically called
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
