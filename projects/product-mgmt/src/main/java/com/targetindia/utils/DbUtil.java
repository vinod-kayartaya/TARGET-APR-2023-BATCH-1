package com.targetindia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
    private  DbUtil() {
    }

    public static Connection newConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");

        String url = rb.getString("jdbc.connection.url");
        String user = rb.getString("jdbc.connection.user");
        String password = rb.getString("jdbc.connection.password");

        return DriverManager.getConnection(url, user, password);
    }
}
