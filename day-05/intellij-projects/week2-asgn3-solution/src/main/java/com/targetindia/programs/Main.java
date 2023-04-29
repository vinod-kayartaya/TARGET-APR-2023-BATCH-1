package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.Rectangle;
import com.targetindia.model.Shape;
import com.targetindia.model.Square;
import org.w3c.dom.css.Rect;

public class Main {

    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle(),
                new Rectangle(),
                new Square(),
                new Circle(2.3),
                new Rectangle(1.2,3.4),
                new Square(4.5),
                new Circle(4.5, "yellow", false),
                new Rectangle(1.2,3.4, "green", true),
                new Square(4.5, "white", true),
                new Square(8.1, "black", true)
        };

        for(Shape s: shapes){
            double area=0;
            double perimeter=0;

            // convert the super type reference to a subtype by careful investigation
            if(s instanceof  Circle){
                Circle c = (Circle) s;
                area = c.getArea();
                perimeter = c.getPerimeter();
            }
            else if(s instanceof Rectangle){ // even a Square is a Rectangle
                Rectangle r = (Rectangle) s;
                area = r.getArea();
                perimeter = r.getPerimeter();
            }

            System.out.printf("(%s) Area = %f and Perimeter = %f\n",
                    s.getClass().getSimpleName(),
                    area,
                    perimeter);
        }

    }
}
