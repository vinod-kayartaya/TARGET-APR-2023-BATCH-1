package com.targetindia.model;

import lombok.Data;

@Data // no-args-constructor, getters, setters, toString, hashCode, equals, canEquals
public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String phone;
    private String city;
}
