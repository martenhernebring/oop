package se.hernebring.games;
import java.util.Scanner;

public class GuessingGameDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GuessingGame gg;
        boolean play = true;
        while(play){
            gg = new GuessingGame();
            int clue = GuessingGame.ERROR;
            while(clue!=GuessingGame.CORRECT){
                System.out.print("Gissa vilket tal jag tänker på? (1-10)");
                System.out.flush();
                int answer = scan.nextInt();
                clue = gg.check(answer);
                if (clue==GuessingGame.CORRECT){
                    System.out.println("Hurra du lyckades!");
                } else if (clue==GuessingGame.HIGHER){
                    System.out.println("Talet jag söker är större än "+answer+".");
                } else if (clue==GuessingGame.LOWER){
                    System.out.println("Talet jag söker är mindre än "+answer+".");
                }
                else if(clue==GuessingGame.ERROR){
                    System.out.println("Talet måste vara mellan 1 och 10");
                }  
            }
            System.out.println("Som bäst har du lyckats på "+GuessingGame.getBestResult()+" gissningar.");
            System.out.println("Som sämst har du lyckats på "+GuessingGame.getWorstResult()+" gissningar.");
            System.out.println("Vill du spela igen? (J/N)");
            String spela = scan.next();
            if(spela.charAt(0) == 'N' || spela.charAt(0) == 'n' )
                play= false;
        }
        scan.close();
    }
}
