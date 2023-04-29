package com.targetindia.programs;

import com.targetindia.utils.DateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

@Slf4j
public class CreateEmployeesCSVFile {
    public static void main(String[] args) {

        String filename = "employees.csv";
        File file = new File(filename);
        boolean fileExists = file.exists();

        try (
                // classes used here for creating objects must implement AutoCloseable
                FileWriter writer = new FileWriter(filename, true);
                PrintWriter out = new PrintWriter(writer);
        ) {
            if (!fileExists) {
                out.println("ID,Name,Email,Salary,HireDate");
            }

            String choice = null;
            do {
                System.out.println("Enter following details of an employee:");
                int id = KeyboardUtil.getInt("ID: ");
                String name = KeyboardUtil.getString("Name: ");
                String email = KeyboardUtil.getString("Email: ");
                double salary = KeyboardUtil.getDouble("Salary: ");
                Date hireDate = KeyboardUtil.getDate("Date of jon: ");
                out.printf("%d,%s,%s,%.2f,%s\n", id, name, email, salary, DateUtil.toString(hireDate));

                choice = KeyboardUtil.getString("Do you want to add another? (yes/no): ");
                if (!choice.equalsIgnoreCase("yes") &&
                        !choice.equalsIgnoreCase("no")) {
                    System.out.println("Wrong choice; aborting.");
                }
            } while (choice.equalsIgnoreCase("yes"));

        } // writer.close(), out.close() called here
        catch (Exception e) {
            log.error("Error: ", e);
        }


    }
}
