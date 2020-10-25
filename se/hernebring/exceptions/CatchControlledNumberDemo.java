package se.hernebring.exceptions;
import java.util.Scanner;

public class CatchControlledNumberDemo {
    final static Scanner scan = new Scanner(System.in, "Cp850");

    public static void main(String[] args) {
        try {
            String input = getInput();
            System.out.println(input);
        } catch (ControlledNumberException cn) {
            System.out.println(cn.getMessage());
            scan.close();
        }
    }

    private static String getInput() throws ControlledNumberException {
        System.out.println("Skriv inte 1");
        String input;
        input = scan.nextLine();
        if(input.equals("1")){
            throw new ControlledNumberException("Du får inte skriva ett. Vad som helst annars går bra.");
        }
        scan.close();
        return input;
    }

}
