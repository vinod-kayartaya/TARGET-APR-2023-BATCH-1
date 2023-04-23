package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sphere extends Circle {

    public Sphere(double radius){
        super(radius);
    }

    @Override
    public double getArea() {
        return 4 * super.getArea();
    }
}
