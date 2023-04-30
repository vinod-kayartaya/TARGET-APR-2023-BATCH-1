package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String email;

    public void print() {
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}
