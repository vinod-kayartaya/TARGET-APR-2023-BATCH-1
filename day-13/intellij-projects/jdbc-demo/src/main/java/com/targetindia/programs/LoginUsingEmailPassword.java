package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;
import org.postgresql.util.OSUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginUsingEmailPassword {
    public static void main(String[] args) throws Exception {

        String sql = "select * from users where email=? and password=?";

        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // 1st round trip
        ) {
            String email = KeyboardUtil.getString("Enter email: ");
            String password = KeyboardUtil.getString("Enter password: ");

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (
                    ResultSet rs = stmt.executeQuery(); // 2nd round trip, carries parameters
            ) {

                if (rs.next()) {
                    System.out.println("Successfully logged in as: ");
                    System.out.printf("Name        : %s%n", rs.getString("name"));
                    System.out.printf("Email       : %s%n", rs.getString("email"));
                    System.out.printf("Department  : %s%n", rs.getString("department"));
                } else {
                    System.out.println("Invalid email/password");
                }
            }
        }
    }

    public static void main_sql_injection(String[] args) throws Exception {

        String email = KeyboardUtil.getString("Enter email: ");
        String password = KeyboardUtil.getString("Enter password: ");

        String sql = "select * from users where email='%s' and password='%s'"
                .formatted(email, password);

        // System.out.println(sql);

        try (
                Connection conn = DbUtil.newConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            if (rs.next()) {
                System.out.println("Successfully logged in as: ");
                System.out.printf("Name        : %s%n", rs.getString("name"));
                System.out.printf("Email       : %s%n", rs.getString("email"));
                System.out.printf("Department  : %s%n", rs.getString("department"));
            } else {
                System.out.println("Invalid email/password");
            }
        }
    }
}
