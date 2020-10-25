package se.hernebring.exceptions;
import java.util.Scanner;

public class CatchNumberIllegalDemo {
    final static Scanner scan = new Scanner(System.in, "Cp850");

    public static void main(String[] args) {
        try {
            String input = getInput();
            System.out.println(input);
        } catch (NumberIllegalException ni) {
            System.out.println(ni.getMessage());
            scan.close();
        }
    }

    private static String getInput() {
        System.out.println("Skriv inte ett nummer");
        String input;
        if (scan.hasNextInt()) {
            throw new NumberIllegalException("Du får inte skriva ett nummer");
        } else {
            input = scan.nextLine();
        }
        scan.close();
        return input;
    }

}
