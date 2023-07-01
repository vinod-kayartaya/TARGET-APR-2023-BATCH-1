package com.targetindia.model;

import lombok.Data;

@Data
public class Student extends Person{
    private int rollno;
    private double gpa;
    private String majorSubject;

    @Override
    public void print() {
        System.out.printf("Roll no        : %d\n", rollno);
        super.print();
        System.out.printf("Major sub      : %s\n", majorSubject);
        System.out.printf("GPA            : %s\n", gpa);
    }

    public String getGrade(){
        if(gpa>7){
            return "Grade A Student";
        }
        if(gpa>5){
            return "Grade B Student";
        }
        if(gpa>4){
            return "Grade C Student";
        }
        return "Grade D Student";
    }
}
