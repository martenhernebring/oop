package se.hernebring.age;
import java.util.Scanner;

public class MatureAndLength {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Ange ålder:");
        int age = scan.nextInt();
        if(age<13){
            System.out.println("Jag får inte behandla din information.");
            System.exit(0);
        }
        System.out.println("Ange förnamn: ");
        String name = scan.next().trim();
        System.out.println("Ange längd (i cm): ");
        int length = scan.nextInt();
        System.out.println("Ditt namn är "+name+" och du är "+length+" cm lång.");
        if(length>174)
            System.out.println("Du är längre än medelsvensson.");
        scan.close();
    }
}