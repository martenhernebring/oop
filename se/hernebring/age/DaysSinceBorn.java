package se.hernebring.age;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class DaysSinceBorn {
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        
        System.out.println("Skriv födelsedatum (ÅÅÅÅ-MM-DD)");
        String date = scan.nextLine();
        String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8);
        int by = Integer.parseInt(year);
        int bm = Integer.parseInt(month);
        int bd = Integer.parseInt(day);
        LocalDate birthDate = LocalDate.of(by,bm,bd);
        long days = ChronoUnit.DAYS.between(birthDate,LocalDate.now());
        System.out.println("Det är "+days+" dagar sedan du föddes.");
        scan.close();
    }
}
