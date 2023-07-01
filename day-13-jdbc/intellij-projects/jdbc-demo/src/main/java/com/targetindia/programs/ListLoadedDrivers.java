package com.targetindia.programs;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ListLoadedDrivers {

    public static void main(String[] args) {

        System.out.println("The following are the drivers that are registered with DriverManager: ");
        System.out.println("------------------------------------------------");

        // When a vendor driver dependency is added to pom.xml, an object of vendor specific class that implements
        // java.sql.Driver is instantiated and registered with DriverManager, automatically.

        // in the past, we had to load the driver class into the VM, during when it would have been automatically
        // registered with DriverManager. For example, `Class.forName("org.h2.Driver");`
        // or DriverManager.registerDriver(new org.h2.Driver());

         String url = "jdbc:oracle:thin://localhost:1521:orcl";
        // String url = "jdbc:sqlserver://localhost:1433/mydb";
        // String url = "jdbc:postgresql://localhost:5432/mydb";
        // String url = "jdbc:h2:tcp://localhost/~/mydb";
//        String url = "jdbc:sqlite://testdb.sqlite";
        DriverManager.drivers()
                .forEach(d -> {
                    try {
                        System.out.printf("%s object acceptsURL(url) is %s%n",
                                d.getClass().getName(), d.acceptsURL(url));
                    } catch (SQLException e) {
                    }
                });

        System.out.println("------------------------------------------------");


    }
}
