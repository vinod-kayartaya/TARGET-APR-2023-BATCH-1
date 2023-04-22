package com.targetindia.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Manager extends Employee {
    private int projectCount;

    public void print() {
        super.print(); // print() in Employee.java
        // can never access the print() in Person.java
        System.out.printf("No.of projects : %s\n", projectCount);
    }
}
