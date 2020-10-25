package se.hernebring.age;
import java.util.Scanner;

public class PersonDemo {
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.print("Skriv in förnamn: ");
        String forNamn=scan.nextLine();
        System.out.print("Skriv in efternamn: ");
        String efterNamn=scan.nextLine();
        System.out.print("Skriv in ålder: ");
        int age = scan.nextInt();

        Person person = new Person(forNamn,efterNamn,age);
        System.out.println(person);
        scan.close();
    }
}
