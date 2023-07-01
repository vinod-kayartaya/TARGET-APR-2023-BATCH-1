package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Circle {
    private double radius;
    private static final double PI = 3.14157;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void printArea(){
        double area = Circle.PI * radius * radius;
        System.out.printf("Area of circle with radius %.2f units is %.2f sq.units\n",
                radius, area);
    }
}
