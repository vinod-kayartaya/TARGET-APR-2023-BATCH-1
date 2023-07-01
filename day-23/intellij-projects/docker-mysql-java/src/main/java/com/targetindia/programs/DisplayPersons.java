package com.targetindia.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayPersons {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:1234/vindb";
        String username = "root";
        String password = "Welcome#123";
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from persons")
        ) {
            while(rs.next()){
                System.out.printf("%2d %-25s %-25s%n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
