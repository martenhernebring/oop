package se.hernebring.bank.exchange;
import java.util.Scanner;

public class ExchangeApp {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final String[] c = { "EUR", "SEK", "NOK", "DKK", "GBP" };
        final Exchange[] exchange = { new EuroExchange(), new NOKExchange(), new DKKExchange(), new GBPExchange() };
        System.out.println(
                "Vi hanterar växlingar i: " + c[0] + ", " + c[1] + ", " + c[2] + ", " + c[3] + ", " + c[4] + ".");
        System.out.println("Vad vill du växla från?");
        String from = scan.next().trim();
        System.out.println("Vad vill du växla till?");
        String to = scan.next().trim();
        System.out.println("Hur många " + from + " vill du växla?");
        int amount = scan.nextInt();
        int oren = 0;
        int cents = 0;
        if (!from.equals(to)) { // Do not convert same currencies
            if (from.equals(c[0])) {
                oren = exchange[0].convertFromCents(100 * amount);
            } else if (from.equals(c[1])) {
                oren = 100 * amount;
            } else if (from.equals(c[2])) {
                oren = exchange[1].convertFromCents(100 * amount);
            } else if (from.equals(c[3])) {
                oren = exchange[2].convertFromCents(100 * amount);
            } else if (from.equals(c[4])) {
                oren = exchange[3].convertFromCents(100 * amount);
            }

            if (to.equals(c[0])) {
                cents = exchange[0].convertToCents(oren);
            } else if (to.equals(c[1])) {
                cents = oren;
            } else if (to.equals(c[2])) {
                cents = exchange[1].convertToCents(oren);
            } else if (to.equals(c[3])) {
                cents = exchange[2].convertToCents(oren);
            } else if (to.equals(c[4])) {
                cents = exchange[3].convertToCents(oren);
            }
        } else {
            cents = 100 * amount;
        }
        System.out.println("Det blir " + cents / 100 + "," + cents % 100 + " " + to + ".");
        scan.close();
    }
}
