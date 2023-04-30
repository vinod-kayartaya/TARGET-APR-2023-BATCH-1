package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ReadAndStoreEmployeesData {
    public static void main(String[] args) throws Exception {
        try (
                FileOutputStream file = new FileOutputStream("employees.data");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            while(true){
                int id = KeyboardUtil.getInt("Enter id: ");
                String name = KeyboardUtil.getString("Enter name: ");
                String email = KeyboardUtil.getString("Enter email address: ");
                double salary = KeyboardUtil.getDouble("Enter salary: ");

                Employee emp = new Employee(id, name, email, salary);
                // convert an object into a series of bytes (serialization)
                // and write the same bytes into a binary file (or send it via network etc.,)
                out.writeObject(emp); // possible only if the class Employee implements Serializable

                String choice = KeyboardUtil.getString("Want to add another? yes/no (yes) :");
                if(choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
            System.out.println("Data stored in file - employees.data");
        } // out.close() and file.close() called here
    }
}
