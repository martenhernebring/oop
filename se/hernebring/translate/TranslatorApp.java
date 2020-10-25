package se.hernebring.translate;
import java.util.Scanner;

public class TranslatorApp {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        Translator tr[] = {new RobbersLanguage(), new AllLanguage()};
        System.out.println("Välj hemligt språk. Rövarspråket (1) Allspråket (2)");
        int choice = scan.nextInt();
        System.out.println("Skriv in text som ska översättas");
        String text;
        if(scan.hasNextLine()){
            text = scan.nextLine();
        }
        text = scan.nextLine();
        System.out.println(tr[choice-1].translate(text));
        scan.close();
    }
}
