package com.targetindia.programs;

import com.targetindia.model.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PolymorphismDemo {

    static void printShapeDetails(Shape shape) { // can be a Circle, Sphere or a Triangle
        log.trace("Shape type is {}", shape.getClass().getSimpleName());
        // the following code is not a good idea.
        // it violates the SOLID principles.
        // this is done here only to demonstrate the use of "instanceof" keyword
        if (shape instanceof Circle || shape instanceof Sphere) {
            Circle c = (Circle) shape; // Sphere is also a Circle (because of inheritance)
            log.trace("Radius of the circle is {} units", c.getRadius());
        } else if (shape instanceof Triangle) {
            Triangle t = (Triangle) shape;
            log.trace("Base and height of triangle are {} and {} respectively",
                    t.getBase(), t.getHeight());
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            log.trace("length and breadth of the rectangle are {} and {} respectively",
                    r.getLength(), r.getBreadth());
        }
        log.trace("Area of this {} is {} sq.units", shape.getClass().getSimpleName(), shape.getArea());
        log.trace("Perimeter of this {} is {} units\n",
                shape.getClass().getSimpleName(), shape.getPerimeter());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(12.34);
        Sphere s1 = new Sphere(12.34);
        Triangle t1 = new Triangle(12.34, 56.78);

        printShapeDetails(c1);
        printShapeDetails(s1);
        printShapeDetails(t1);
        printShapeDetails(new Rectangle(12.34, 56.78));
    }
}
