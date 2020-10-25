package se.hernebring.age;
import java.util.Scanner;
//Ett program som ber användaren skriva sitt födelseår.
//Programmet skriver då ut om man är myndig eller ej.

public class Mature{
    public static void main(String[] args) {
        int birthYear;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in ditt födelseår:");
        birthYear = scanner.nextInt(); //2001 eller tidigare är myndig
        if(birthYear<2002)
            System.out.println("Du är myndig");
        else if(birthYear==2002)
            System.out.println("Du är myndig om du fyllt år tidigare detta år.");
        else System.out.println("Du är ännu inte myndig");
        scanner.close();
    }
}