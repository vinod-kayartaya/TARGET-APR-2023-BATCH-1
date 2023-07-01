package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo4 {
    public static void main(String[] args) {
        List<Employee> emps = Employee.getDummyEmployeeList();

        // print only the names of the employees:
        emps.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);

        System.out.println("------------------------------");
        // print all employee names who are earning more than $7500
        emps.stream()
                .filter(e -> e.getSalary() > 7500) // stream of employees earning more than 7500
                .map(e -> e.getName()) // stream of strings (names of employees)
                .forEach(System.out::println);
        System.out.println("------------------------------");
        // print all employee names and salaries, who are earning more than $6500
        emps.stream()
                .filter(e -> e.getSalary() > 6500) // stream of employees earning more than 6500
                // .sorted() // trying to sort employees, but Employee is not comparable!
                .map(e -> e.getName() + " earns $" + e.getSalary()) // stream of strings (names of employees)
                .sorted() // trying to sort the stream of strings
                .forEach(System.out::println);
        System.out.println("------------------------------");

        // print all employee names and salaries, who are earning more than $5500. sort by salary as well
        emps.stream()
                .filter(e -> e.getSalary() > 5500) // stream of employees earning more than 5500
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .map(e -> e.getName() + " earns $" + e.getSalary()) // stream of strings (names of employees)
                .forEach(System.out::println);
        System.out.println("------------------------------");

        // print all employee names and salaries, who are earning more than $5500. sort by salary as well
        emps.stream()
                .filter(e -> e.getSalary() > 5500) // stream of employees earning more than 5500
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .map(e -> new Object[]{e.getName(), e.getSalary(), e.getDepartment()}) // stream of strings (names of employees)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("------------------------------");
        // get a list of strings representing unique departments
        List<String> departments = emps.stream()
                .map(e -> e.getDepartment())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        departments.forEach(System.out::println);
        System.out.println("------------------------------");

    }
}
