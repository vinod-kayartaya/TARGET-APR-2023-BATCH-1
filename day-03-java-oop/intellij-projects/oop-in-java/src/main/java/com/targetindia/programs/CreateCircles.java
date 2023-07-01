package com.targetindia.programs;

import com.targetindia.model.Circle;

public class CreateCircles {
    public static void main(String[] args) {

        Circle c1 = new Circle(12.34);
        c1.printArea();

        Circle[] circles = new Circle[1000];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle((1 + Math.random()) * 100);
        }


    }
}
