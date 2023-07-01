package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Circle implements  Shape{
    private double radius;

    @Override
    public double getArea() {
        return Shape.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
