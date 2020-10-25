package se.hernebring.shapes.circle;
public class AreaAndCircumferenceFloat {
    public static void main(String[] args) {
        float radius = 1e20f;  //12.3F funkade ok

        //code goes here, use StrictMath.PI
        float area = (float) StrictMath.PI*radius*radius;
        float circumference = 2*(float)StrictMath.PI*radius;

        System.out.printf("Omkretsen på cirkeln är %.2f.\n", circumference);
        System.out.printf("\u1f604 Arean på cirkeln är %.2f.\n", area);
    }
}
