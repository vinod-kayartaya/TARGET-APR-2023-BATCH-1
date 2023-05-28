package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayEmployeesBySalaryRange {
    public static void main(String[] args) {
        String sql = "select * from employees where salary between ? and ?";

        double minSal, maxSal;

        if (args.length == 0) {
            minSal = KeyboardUtil.getDouble("Enter value for minimum salary: ");
            maxSal = KeyboardUtil.getDouble("Enter value for maximum salary: ");
        } else if (args.length == 1) {
            minSal = 0;
            maxSal = Double.parseDouble(args[0]);
        } else {
            minSal = Double.parseDouble(args[0]);
            maxSal = Double.parseDouble(args[1]);
        }

        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setDouble(1, minSal);
            stmt.setDouble(2, maxSal);

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                printEmployeeRecords(rs);
            } // rs.close() here

        } // conn.close() and stmt.close() here
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printEmployeeRecords(ResultSet rs) throws SQLException {
        System.out.printf("%5s %-30s %-35s %-25s %-12s %10s%n"
                , "ID", "Name", "Email", "Department", "Phone", "Salary");
        line(122);

        while (rs.next()) {
            System.out.printf("%5d %-30s %-35s %-25s %-12s %10.2f%n"
                    , rs.getInt("id")
                    , rs.getString("first_name") + " " + rs.getString("last_name")
                    , rs.getString("email")
                    , rs.getString("department")
                    , rs.getString("phone")
                    , rs.getDouble("salary"));
        }
        line(122);
    }

    static void line(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
