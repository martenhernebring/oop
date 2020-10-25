package se.hernebring.postoffice;
import java.util.Scanner;
//Ett program som läser in poäng på provet och returerar betyget

public class CorrectDimensions{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in poäng på provet:");
        int testScore = scanner.nextInt(); //G(20+)VG(35+)MVG(44+)
        if(testScore<20)
            System.out.println("Du fick IG.");
        else if(testScore<35)
            System.out.println("Du fick G.");
        else if(testScore<44)
            System.out.println("Du fick VG.");
        else System.out.println("Du fick MVG.");
        scanner.close();
    }
}