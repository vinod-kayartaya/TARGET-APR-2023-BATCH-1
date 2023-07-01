package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.HashSet;
import java.util.Set;

public class SetWithCustomClass {
    public static void main(String[] args) {
        Person p1 = new Person("Vinod", 49, 5.7, true);
        Person p2 = new Person("Ramesh", 29, 5.9, false);
        Person p3 = new Person("Vinod", 49, 5.7, true); // duplicate of p1
        Person p4 = new Person("Vinod", 25, 6.1, false);
        Person p5 = new Person("Vinod", 25, 5.5, true);
        Person p6 = new Person("Ramesh", 29, 5.9, false); // duplicate of p2

        System.out.printf("p1.hashCode() = %d%n", p1.hashCode());
        System.out.printf("p2.hashCode() = %d%n", p2.hashCode());
        System.out.printf("p3.hashCode() = %d%n", p3.hashCode());
        System.out.printf("p4.hashCode() = %d%n", p4.hashCode());
        System.out.printf("p5.hashCode() = %d%n", p5.hashCode());
        System.out.printf("p6.hashCode() = %d%n", p6.hashCode());

        Set<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2);
        people.add(p3); // checks if p3.hashCode() == p1.hashCode(), p2.hashCode()
        people.add(p4);
        people.add(p5);
        people.add(p6);

        System.out.printf("There are %d persons%n", people.size());
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
