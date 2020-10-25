package se.hernebring.shapes.circle;
public class AreaAndCircumferenceDouble {
    public static void main(String[] args) {
        double radius = 1e20; //12.3 funkade ok

        //code goes here, use StrictMath.PI
        double area = StrictMath.PI*radius*radius;
        double circumference = 2*StrictMath.PI*radius;

        System.out.printf("Omkretsen på cirkeln är %.2f.\n", circumference);
        System.out.printf("Arean på cirkeln är %.2f.\n", area);
    }
}
