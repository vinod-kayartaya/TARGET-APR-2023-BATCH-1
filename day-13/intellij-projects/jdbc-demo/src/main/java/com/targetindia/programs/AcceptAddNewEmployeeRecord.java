package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.Statement;

public class AcceptAddNewEmployeeRecord {

    public static void main(String[] args) {

        System.out.println("Enter new employee details:");
        int id = KeyboardUtil.getInt("ID         : ");
        String fname = KeyboardUtil.getString("Firstame   : ");
        String lname = KeyboardUtil.getString("Lastname   : ");
        String email = KeyboardUtil.getString("Email      : ");
        String phone = KeyboardUtil.getString("Phone      : ");
        String dept = KeyboardUtil.getString("Department : ");
        double salary = KeyboardUtil.getDouble("Salary (₹) : ");

        String sql = "insert into employees values (%d, '%s', '%s', '%s', '%s', %f, '%s')"
                .formatted(id, fname, lname, email, phone, salary, dept);

        try (
                Connection conn = DbUtil.newConnection();
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql);
            System.out.println("New employee record added to the database table");
        }
        catch(Exception e){
            System.out.println("We encountered an error while trying to add new employee record");
            System.out.printf("Error message: %s%n", e.getMessage());
        }

    }
}
