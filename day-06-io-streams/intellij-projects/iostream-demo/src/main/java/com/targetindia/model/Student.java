package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Student extends Person   implements Serializable{
    // Since Person is not a Serializable class, the members inherited from Person
    // to this class will not be serialized when an object of this class is serialized
    private int rollno;
    private double gpa;

    public Student(int rollno, String name, String email, double gpa) {
        super(name, email);
        this.rollno = rollno;
        this.gpa = gpa;
    }

    public void print(){
        System.out.println("Roll# : " + rollno);
        super.print();
        System.out.println("GPA   : " + gpa);
        System.out.println("---------------------------");
    }
}
