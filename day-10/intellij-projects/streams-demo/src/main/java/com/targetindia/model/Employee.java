package com.targetindia.model;


import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static List<Employee> getDummyEmployeeList() {
        return Arrays.asList(new Employee(1, "Vale Pavia", "Accounting", 6080),
                new Employee(2, "Yasmeen Siemantel", "Accounting", 7077),
                new Employee(3, "Christye Bogaert", "Human Resources", 7001),
                new Employee(4, "Melli Sundin", "Sales", 3115),
                new Employee(5, "Reinald Harrismith", "Human Resources", 4490),
                new Employee(6, "Bevon Hain", "Sales", 4888),
                new Employee(7, "Cornie Greenset", "Accounting", 8142),
                new Employee(8, "Corie Frankland", "Product Management", 3740),
                new Employee(9, "Kaia Jeannard", "Sales", 4346),
                new Employee(10, "Ealasaid Klauer", "Sales", 6360),
                new Employee(11, "Florian Petrolli", "Human Resources", 2982),
                new Employee(12, "Janelle Guillot", "Training", 5693),
                new Employee(13, "Jobey Persent", "Services", 5224),
                new Employee(14, "Gare Cabrara", "Sales", 6436),
                new Employee(15, "Yehudi Crossdale", "Research and Development", 2765),
                new Employee(16, "Tedie Viollet", "Marketing", 5571),
                new Employee(17, "Marten Garham", "Support", 3251),
                new Employee(18, "Franni Scotchford", "Product Management", 5107),
                new Employee(19, "Rab Yosevitz", "Sales", 8907),
                new Employee(20, "Feodor Fensome", "Marketing", 4188),
                new Employee(21, "Alix Jovey", "Business Development", 5425),
                new Employee(22, "Brooks Johnston", "Business Development", 5486),
                new Employee(23, "Terrijo Andriolli", "Human Resources", 2969),
                new Employee(24, "Benito Sprott", "Marketing", 8984),
                new Employee(25, "Leora Millichip", "Services", 5207));
    }
}
