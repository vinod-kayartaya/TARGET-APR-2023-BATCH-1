package com.targetindia.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private double height;
    private boolean isMarried;
}
