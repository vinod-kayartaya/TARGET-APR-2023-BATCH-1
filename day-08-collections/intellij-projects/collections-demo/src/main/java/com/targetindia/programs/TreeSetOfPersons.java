package com.targetindia.programs;

import com.targetindia.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class TreeSetOfPersons {
    // note: Person does not implement Comparable (and for some reason, imagine you do not have
    // access to the source code and/or cannot modify the class)

    static class PersonAgeComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();
        }
    }

    static class PersonNameComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }


    public static void main(String[] args) {

        Person p1 = new Person("Vinod", 49, 5.7, true);
        Person p2 = new Person("Ramesh", 29, 5.9, false);
        Person p3 = new Person("Vinod", 49, 5.7, true); // duplicate of p1
        Person p4 = new Person("Vinod", 25, 6.1, false);
        Person p5 = new Person("Vinod", 25, 5.5, true);
        Person p6 = new Person("Ramesh", 29, 5.9, false); // duplicate of p2

        Comparator<Person> cmp; // an object that knows how to compare two Person objects
        cmp = new PersonAgeComparator();

//        Set<Person> people = new TreeSet<>(cmp);
//        Set<Person> people = new TreeSet<>(new PersonNameComparator());

        // anonymous object
        cmp = new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                int r = p1.getName().compareTo(p2.getName());
                if (r == 0) {
                    r = p1.getAge() - p2.getAge();
                    if (r == 0) {
                        r = Double.compare(p1.getHeight(), p2.getHeight());
                        if (r == 0) {
                            return Boolean.compare(p1.isMarried(), p2.isMarried());
                        }
                    }
                }
                return r;
            }
        };

        Set<Person> people = new TreeSet<>(cmp);

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);

        for (Person p : people) {
            log.trace("person = {}", p);
        }
    }
}
