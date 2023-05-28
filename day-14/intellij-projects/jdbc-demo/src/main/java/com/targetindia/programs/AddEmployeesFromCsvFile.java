package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Slf4j
public class AddEmployeesFromCsvFile {
    public static void main(String[] args) {
        String sql = "insert into employees (id, first_name, last_name, email, phone, salary, department) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        try (
                FileReader file = new FileReader("employees.csv");
                BufferedReader in = new BufferedReader(file);
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // preparation phase
        ) {
            String line = in.readLine(); // skip the HEADER
            int rowCount = 0;
            while ((line = in.readLine()) != null) {
                rowCount++;
                String[] fields = line.split(",");
                try {
                    int id = Integer.parseInt(fields[0]);
                    String fname = fields[1];
                    String lname = fields[2];
                    String email = fields[3];
                    String phone = fields[4];
                    double salary = Double.parseDouble(fields[5]);
                    String dept = fields[6];

                    stmt.setInt(1, id);
                    stmt.setString(2, fname);
                    stmt.setString(3, lname);
                    stmt.setString(4, email);
                    stmt.setString(5, phone);
                    stmt.setDouble(6, salary);
                    stmt.setString(7, dept);

                    // do not execute yet, but store it locally
                    stmt.addBatch();
                } catch (Exception e) {
                    // ignore the current line, and move to the next one
                    // exception ducking!
                }
            }
            // set the batch size for batch execution
            // stmt.setFetchSize(100);
            stmt.executeBatch(); // execute the batch
            System.out.printf("Added %d records%n", rowCount);
        } catch (Exception e) {
            log.warn("Error", e);
            e.printStackTrace();
        }
    }
}
