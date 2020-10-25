package se.hernebring.shapes.rectangle;
import java.util.Scanner;
//Ett program som ber användaren att mata bredd och höjd på en rektangel.
//Programmet skriver då ut omkrets och area med två decimaler.

public class DifferentiateIntAndDoubleInput{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv höjden på rektangeln (i cm)");
        if(scanner.hasNextInt()){
            int height = scanner.nextInt();
            System.out.println("Skriv bredden på rektangeln (i cm)");
            if(scanner.hasNextInt()){
                int width = scanner.nextInt();
                int area = height*width;
                int circumference = 2*height+2*width;
                System.out.println("Rektangelns omkrets är "+circumference+" centimeter och arean är "+area+" kvadratcentimeter.");
            } else{
                double width = scanner.nextDouble();
                double area = height*width;
                double circumference = 2*height+2*width;
                System.out.printf("Rektangelns omkrets är %.2f. centimeter och arean är %.2f. kvadratcentimeter.\n", circumference,area);
            }
        } else{
            double height = scanner.nextDouble();
            System.out.println("Skriv bredden på rektangeln");
            double width = scanner.nextDouble();
            double area = height*width;
            double circumference = 2*height+2*width;
            System.out.printf("Rektangelns omkrets är %.2f. centimeter och arean är %.2f. kvadratcentimeter.\n", circumference,area);
        }
        scanner.close();
    }
}