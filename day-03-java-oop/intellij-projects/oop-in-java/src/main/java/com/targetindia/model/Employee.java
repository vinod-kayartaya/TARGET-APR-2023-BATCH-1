package com.targetindia.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Employee extends Person { // EMPLOYEE object IS-A PERSON object
    private int id;
    private double salary;
    private String department;

    // override the print function inherited from the superclass
    public void print() {
        System.out.printf("ID             : %d\n", id);
        super.print();
        System.out.printf("Salary         : Rs.%.2f\n", salary);
        System.out.printf("Department     : %s\n", department == null ? "" : department);
    }

    public String getGrade() {
        if (salary > 100000) {
            return "Grade A Employee";
        }
        if (salary > 75000) {
            return "Grade B Employee";
        }
        if (salary > 5000) {
            return "Grade C Employee";
        }
        return "Grade D Employee";
    }
}
