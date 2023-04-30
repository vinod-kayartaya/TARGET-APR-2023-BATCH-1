package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Employee implements Serializable {

    static final long serialVersionUID = 1L;

    private int id;         // 4 bytes
    private String name;    // 8 bytes
    private String email;   // 8 bytes
    private double salary;  // 8 bytes
    transient private Address address = new Address();

    public Employee(int id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public void print(){
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Email   : " + email);
        System.out.println("Salary  : $" + salary);
        if(address!=null){
            System.out.println("Employee lives in the following address: ");
            System.out.println("Street  : "+address.getStreet());
            System.out.println("Area    : "+address.getArea());
            System.out.println("City    : "+address.getCity());
            System.out.println("State   : "+address.getState());
        }
        System.out.println("-----------------------");
    }
}
