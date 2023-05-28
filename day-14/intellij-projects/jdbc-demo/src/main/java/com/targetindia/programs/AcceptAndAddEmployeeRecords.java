package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Slf4j
public class AcceptAndAddEmployeeRecords {
    public static void main(String[] args) {
        String sql = "insert into employees (id, first_name, last_name, email, phone, salary, department) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DbUtil.newConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // preparation phase
        ) {
            conn.setAutoCommit(false);
            while(true){
                System.out.println("Enter new employee details:");
                int id = KeyboardUtil.getInt("ID         : ");
                String fname = KeyboardUtil.getString("Firstame   : ");
                String lname = KeyboardUtil.getString("Lastname   : ");
                String email = KeyboardUtil.getString("Email      : ");
                String phone = KeyboardUtil.getString("Phone      : ");
                String dept = KeyboardUtil.getString("Department : ");
                double salary = KeyboardUtil.getDouble("Salary (₹) : ");

                // now we can send these values to the DB server for executing the command
                // given during the preparation phase
                // 1. set the parameter values
                stmt.setInt(1, id);
                stmt.setString(2, fname);
                stmt.setString(3, lname);
                stmt.setString(4, email);
                stmt.setString(5, phone);
                stmt.setDouble(6, salary);
                stmt.setString(7, dept);
                // 2. execute the command (which is already there in the server)
                stmt.execute(); // note that we are not sending the SQL command here
                // at this time, the record is inserted, but not committed `conn.setAutoCommit(false)`
                // hence, the record added is not visible to other clients.
                // The records are visible to the other clients, once "committed".
                // If required, the changes to the DB server by this program can be un-done, by calling
                // the conn.rollback() method

                String ans = KeyboardUtil.getString("Do you want to add another (yes/no): [yes] ");
                if(ans.equalsIgnoreCase("no")){
                     break;
                }
            }

            conn.commit();
            System.out.println("Records are now visible to other users");
        } catch (Exception e) {
            log.warn("Error", e);
            e.printStackTrace();
        }
    }
}
