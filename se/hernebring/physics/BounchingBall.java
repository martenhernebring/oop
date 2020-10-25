package se.hernebring.physics;
import java.util.Scanner;

//Ett program som beräknar antalet studs från en boll
public class BounchingBall {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.print("Skriv in höjden i meter: ");
        double height = scan.nextDouble();
        scan.close();
        int studsar = 0;
        for(;height>=0.01;height*=0.7,studsar++){
            ;
        }
        System.out.println("Bollen studsar "+studsar+" gånger.");
    }
}
