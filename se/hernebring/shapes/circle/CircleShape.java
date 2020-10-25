package se.hernebring.shapes.circle;
import se.hernebring.shapes.Shape;

public class CircleShape extends Shape{
    private double radius;

    public CircleShape(double radius) {
        super("circle");
        this.radius=radius;
    }
    
    @Override
    public String toString() {
        return String.format(super.toString()+"\t\tradius: %.2f",radius);
    }
}
