package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

public class CallStoredProcedure {
    public static void main(String[] args) {
        String fname = KeyboardUtil.getString("Firstame   : ");
        String lname = KeyboardUtil.getString("Lastname   : ");
        String email = KeyboardUtil.getString("Email      : ");
        String phone = KeyboardUtil.getString("Phone      : ");
        String dept = KeyboardUtil.getString("Department : ");

        String cmd = "{call add_new_employee(?,?,?,?,?,?,?)}";
        try (
                Connection conn = DbUtil.newConnection();
                CallableStatement stmt = conn.prepareCall(cmd);
        ) {
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, dept);
            stmt.registerOutParameter(6, Types.INTEGER);
            stmt.registerOutParameter(7, Types.DOUBLE);

            stmt.execute();

            int id = stmt.getInt(6);
            double salary = stmt.getDouble(7);

            System.out.println("New employee record created successfully with the following details: ");
            System.out.printf("ID       : %d%n", id);
            System.out.printf("Salary   : ₹ %.2f%n", salary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
