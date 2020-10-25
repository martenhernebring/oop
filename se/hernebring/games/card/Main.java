package se.hernebring.games.card;
import java.util.Scanner;

/**@author Mårten Hernebring, Niklas Johansson, Tom Karlsson, Anton Edwards, Erik Blidner, Henrik Buller
 * A simple 2-player card where players gets points if they guessed the next card correctly.
 */

public class Main {
    /**Class constants for scanning and adding Swedish outputs to String in Engine class */
    public static final Scanner SCAN = new Scanner(System.in, "Cp850"); // Using Swedish input shell;
    public static final String CORRECT = "Rätt! Kortet var ";
    public static final String CONT = " fortsätt spela nu.";
    public static final String WRONG = "Fel! Kortet var ";
    public static final String LET = " som var under! Låt ";
    public static final String NOW = "Nu ska ";
    public static final String PLAY = " spela.";
    public static final String DRAW = "Det blev oavgjort. Lycka till nästa gång.";
    public static final String WON = " vann! Kanske ";
    public static final String REMATCH = " vill ha revansch.";

    /**Main method setup simple 2-player card where players gets points if they guessed the next card correctly. 
     * @param args not used and not checked.
    */
    public static void main(String[] args) {
        //Welcoming and setting player names
        System.out.println("Välkomna till vårt roliga spel.");
        System.out.print("Vad heter spelare1: ");
        System.out.flush();
        String player1name = SCAN.nextLine();
        System.out.print("Vad heter spelare2: ");
        System.out.flush();
        String player2name = SCAN.nextLine();

        //Randomly select who gonna start
        String whoStarts = Engine.start(player1name,player2name);
        System.out.println("Nu ska " + whoStarts + " spela först.");
        int playerChoice = 0;
        while (true) { //play until both players wants to quit
            do { //one player at a time will guess the next card
                if(!Engine.both() && playerChoice == 3){ //for changing player after one quit first time
                    System.out.println("Båda måste spela minst en gång.");
                    String changePlayer = Engine.nextPlayer();
                    System.out.println(changePlayer);
                } else{
                    Engine.drawCard(); //Drawing card if not making the change of players for the first time
                }
                //Displaying the board card
                System.out.println("Bordet har: " + Engine.getOldEngC());
                System.out.println("Gissa om nästa kort är över (1) eller under (2). Avsluta (3)");
                playerChoice = SCAN.nextInt(); //Player inputs the next card guess
                SCAN.nextLine();
                String result = Engine.guess(playerChoice); //Engine checks the answer
                System.out.println(result); //and prints the result

            } while (!Engine.both() || playerChoice != 3); //both players needs to play or want to quit

            String hiscores = Engine.checkScores();
            System.out.println(hiscores);
            
            //Ask if players wants to play again
            System.out.println("Vill ni spela igen? Ja (1). Nej (2)");
            int choice = SCAN.nextInt();
            SCAN.nextLine();
            if (choice == 1) {
                continue; //play again
            } else {
                break; //quit
            }
        } //After quitting calculating the total rounds
        System.out.println("Ni spelade totalt "+Player.getRounds()+" rundor. Tack så mycket för idag. Hej då!");
    }

}
