package com.targetindia.programs;

import com.targetindia.model.Artist;
import com.targetindia.model.Employee;
import com.targetindia.model.Person;
import com.targetindia.model.Student;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1122);
        e1.setSalary(3847);
        e1.setFirstname("John");
        e1.setLastname("Doe");
        e1.setEmail("johndoe@xmpl.com");
        e1.setPhone("555 938 2234");
        e1.setDepartment("ADMIN");

        Student s1 = new Student();
        s1.setRollno(984);
        s1.setFirstname("Rajiv");
        s1.setEmail("rajiv@xmpl.com");
        s1.setGpa(6.78);
        s1.setMajorSubject("Maths");

        Person p1;
        // can assign p1 = e1; ?
        // p1 is a reference of Person type, and on the RHS, we need an object of Person type
        // e1 is a reference of an Employee type, but because of inheritance we can say that
        // an object of Employee IS-A object of Person type.
        // Hence, it is safe to say that e1 refers to an object of Person type.
        p1 = e1;

        // can we say Employee e2; e2 = p1; ? (because p1 is e1, and if this assignment is okay, then e2=e1)
        // This is not correct, since every Person reference need not refer to only Employee objects.

        // what happens here?
        p1.print(); // late binding
        System.out.printf("Employee's grade is %s\n", p1.getGrade());
        // method call is bound to the actual method body at the runtime.
        // at the runtime, p1 refers to an object of Employee, and hence the print() is called from
        // Employee.java

        System.out.println();

        p1 = s1;
        p1.print();
        System.out.printf("Student's grade is %s\n", p1.getGrade());

        // line 37 and 45 are identical, but produce different output
        // based on the object that p1 refers at the time of method execution.

        Artist a1 = new Artist();
        a1.getGrade();

    }
}
