package com.targetindia.programs;

import com.targetindia.model.Person;

public class ObjectDemo {
    public static void main(String[] args) {
        Person p1; // reference
        // error: p1 is not initialized yet, hence cannot access
        // System.out.println("p1 is " + p1);

        p1 = new Person(); // p1.name is null, p1.age is 0
        System.out.println("p1 is " + p1);
        System.out.println("p1.name is " + p1.name);
        System.out.println("p1.age is " + p1.age);

        p1.name = "Vinod Kumar";
        p1.age = 49876; // this is probably an invalid value keeping Person's age in mind
        System.out.println("After changing the values of p1's members,");
        System.out.println("p1.name is " + p1.name);
        System.out.println("p1.age is " + p1.age);


    }
}
