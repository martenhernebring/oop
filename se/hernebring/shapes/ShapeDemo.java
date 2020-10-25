package se.hernebring.shapes;

import java.util.ArrayList;
import java.util.List;

import se.hernebring.shapes.circle.CircleShape;
import se.hernebring.shapes.triangle.TriangleShape;

public class ShapeDemo {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new CircleShape(3.14));
        shapeList.add(new CircleShape(1.23));
        shapeList.add(new TriangleShape(2.5, 1));
        shapeList.add(new TriangleShape(3.33, 2));

        for (Shape shape : shapeList) {
            System.out.println(shape);
        }
    }
}
