package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Triangle implements Shape {
    private double base;
    private double height;

    @Override
    public double getArea() {
        return base * height * 0.5;
    }
}
