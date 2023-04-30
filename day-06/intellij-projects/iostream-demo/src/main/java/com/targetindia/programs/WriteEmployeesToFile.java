package com.targetindia.programs;

import com.targetindia.model.Address;
import com.targetindia.model.Employee;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteEmployeesToFile {
    public static void main(String[] args) throws Exception {
        try (
                FileOutputStream file = new FileOutputStream("employees.data");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            Address adr = new Address();
            adr.setState("Karnataka");
            adr.setCity("Bangalore");
            adr.setArea("ISRO layout");
            adr.setStreet("1st cross 1st main");

            Employee[] emps = {
                    new Employee(11, "Ramesh", "ramesh@xmpl.com", 45000),
                    new Employee(22, "Rahul", "rahul@xmpl.com", 24000),
                    new Employee(33, "Suresh", "suresh@xmpl.com", 35500)
            };
            emps[1].setAddress(adr);

            for (Employee emp : emps) {
                out.writeObject(emp); // emp.address will not be written to the file, since it is transient
                System.out.println("Stored this employee information in the file: ");
                emp.print();
            }
            System.out.println("Data stored in file - employees.data");
        } // out.close() and file.close() called here
    }
}
