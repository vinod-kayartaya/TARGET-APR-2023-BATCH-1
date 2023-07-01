package com.targetindia.model;

import lombok.Data;

@Data
public abstract class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public  void print() {
        System.out.printf("Name           : %s %s\n", firstname, lastname == null ? "" : lastname);
        System.out.printf("Email id       : %s\n", email == null ? "" : email);
        System.out.printf("Phone number   : %s\n", phone == null ? "" : phone);
    }

    public abstract String getGrade();


}
