package com.targetindia.model;

    public interface Shape {
        double PI = 3.14157; // public final static

    double getArea(); // public abstract

    default double getPerimeter(){
        throw new RuntimeException("Method not implemented!");
    }
}
