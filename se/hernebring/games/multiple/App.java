package se.hernebring.games.multiple;
import java.util.InputMismatchException;

public class App {

    public static void main(String[] args) {
        Game games[] = { new GuessingGame(), new MultiplicationGame(), new StenGame(), new WaitingGame() };
        while (true) {
            System.out.print("Välj alternativ: ");
            System.out.flush();
            for (int i = 0; i < games.length; i++) {
                System.out.print("(" + (i + 1) + ") " + games[i].getName() + " ");
            }
            System.out.println("(" + (games.length + 1) + ") Avsluta.");
            int spel;
            try{
                spel = Utils.scan.nextInt();
                Utils.scan.nextLine();
            } catch (InputMismatchException e){
                 System.out.println("Skriv in ett heltal.");
                 spel = -1;
                 Utils.scan.next();
            }
            if (spel == games.length + 1) {
                break;
            } else if (spel > 0 && spel <= games.length) {
                String result = games[spel - 1].play();
                System.out.println(result);
            }
        }
        Utils.scan.close();
    }
}
