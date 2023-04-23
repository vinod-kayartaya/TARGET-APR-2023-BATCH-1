package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Rectangle implements Shape {
    private double length;
    private double breadth;

    @Override
    public double getArea() {
        return length * breadth;
    }
}
