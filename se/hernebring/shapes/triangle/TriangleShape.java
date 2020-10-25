package se.hernebring.shapes.triangle;
import se.hernebring.shapes.Shape;

public class TriangleShape extends Shape {
    private double height, width;

    public TriangleShape(double height, double width) {
        super("triangle");
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format(super.toString()+"\twidth: %.2f\theight: %.2f\t",width,height);
    }

}
