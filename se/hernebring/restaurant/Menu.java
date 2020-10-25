package se.hernebring.restaurant;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        System.out.println("Vad vill du äta?");
        System.out.println("1. Förrätt.");
        System.out.println("2. Varmrätt.");
        System.out.println("3. Fika.");

        final Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        switch (val) {
            case 1:
                System.out.println("Det finns pasta, bröd och sallad.");
                break;
            case 2:
                System.out.println("Det finns köttfärssås, korv och kebab.");
                break;
            case 3:
                System.out.println("Det finns kaffe, bulle och kaka.");
                break;
            default:
                System.out.println("ERROR");
        }
        scan.close();
    }
}
