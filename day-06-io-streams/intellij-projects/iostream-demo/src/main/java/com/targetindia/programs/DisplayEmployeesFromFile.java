package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DisplayEmployeesFromFile {
    public static void main(String[] args) throws Exception {
        try (
                FileInputStream file = new FileInputStream("employees.data");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            while (true) {
                try {
                    // deserialization: a process of converting a series of bytes into
                    // an object of a class (by reading the bytes from a file or another source
                    // like network socket).
                    Object obj = in.readObject();
                    if(obj instanceof Employee){
                        Employee emp = (Employee) obj;
                        emp.print();
                        //System.out.println(emp);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }
}
