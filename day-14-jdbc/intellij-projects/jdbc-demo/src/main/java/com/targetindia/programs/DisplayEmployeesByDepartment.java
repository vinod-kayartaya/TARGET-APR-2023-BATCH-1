package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayEmployeesByDepartment {
    public static void main(String[] args) {
        String sql = "select * from employees where lower(department) = lower(?)";
        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            String dept = KeyboardUtil.getString("Enter department name to search: ");
            stmt.setString(1, dept);

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                DisplayEmployeesBySalaryRange.printEmployeeRecords(rs);
            } // rs.close() here
        } // conn.close() and stmt.close() here
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
