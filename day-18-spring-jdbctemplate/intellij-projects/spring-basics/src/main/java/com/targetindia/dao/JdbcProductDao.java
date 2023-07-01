package com.targetindia.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcProductDao implements ProductDao {

    @Value("${jdbc.connection.driverClassName}") // dependency injection
    private String driverClassName;
    @Value("${jdbc.connection.url}")
    private String url;
    @Value("${jdbc.connection.user}")
    private String user;
    @Value("${jdbc.connection.password}")
    private String password;

    private Connection createConnection() throws Exception {
        Class.forName(driverClassName);
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public long count() {
        try (
                Connection conn = this.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) from products")
        ) {
            rs.next(); // move the rs to the first record
            return rs.getLong(1); // return the 1st column of the current (and the only) row
        } // rs.close()/stmt.close()/conn.close() called here
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
