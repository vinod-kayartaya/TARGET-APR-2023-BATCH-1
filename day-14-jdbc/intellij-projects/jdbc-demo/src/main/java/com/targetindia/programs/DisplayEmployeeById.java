package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayEmployeeById {
    public static void main(String[] args) {
        String sql = "select * from employees where id=?";
        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            int id = KeyboardUtil.getInt("Enter employee id to search: ");
            stmt.setInt(1, id);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if(rs.next()){
                    System.out.printf("Details of employee with id %d%n%n", id);
                    System.out.printf("Name            : %s %s%n", rs.getString("first_name"), rs.getString("last_name"));
                    System.out.printf("Salary          : ₹ %.2f%n", rs.getDouble("salary"));
                    System.out.printf("Department      : %s%n", rs.getString("department"));
                    System.out.printf("Email address   : %s%n", rs.getString("email"));
                    System.out.printf("Phone number    : %s%n", rs.getString("phone"));
                }
                else {
                    System.out.printf("No record of any employee with id %d%n", id);
                }
            } // rs.close() here
        } // conn.close() and stmt.close() here
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
