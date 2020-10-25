package se.hernebring.exceptions;
import java.util.Scanner;

/**ENDAST FÖR ÖVNING OCH INTE FÖR FLÖDESKONTROLL! */
public class CatchIllegalArgumentDemo {
    final static Scanner scan = new Scanner(System.in, "Cp850");

    public static void main(String[] args) {
        try {
            int number = readNumber();
            System.out.println(number);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        scan.close();
    }

    private static int readNumber() {
        System.out.println("Skriv in ett heltal.");
        int heltal = scan.nextInt();
        if (heltal > 10) {
            throw new IllegalArgumentException("IllegalArgumentException: Heltal får inte vara större än 10.");
        } else if (heltal < 0) {
            throw new RuntimeException("RuntimeException: Heltal får inte vara mindre än 0.");
        } else{
            return heltal;
        }
    }
}