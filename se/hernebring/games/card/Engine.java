package se.hernebring.games.card;
import java.util.Random;

/**@author Mårten Hernebring, Niklas Johansson, Tom Karlsson, Anton Edwards, Erik Blidner, Henrik Buller
 * A simple engine shell for playing any 2-player guess the next card game using Player model with Ace lowest.
 */

public class Engine {
    /**Only the 13 card ranks are counted. From low to high Ace, 2-10, Jack, Queen, King */
    public static final int CARDS = 13;

    //Instance variables for generating cards & booleans, players, who played and which card was generated.
    private static Random randGen;
    private static Player player1;
    private static Player player2;
    private static boolean firstPlays;
    private static boolean bothHasPlayed;
    private static int newC;
    private static int oldC;

    /**Setup 2 player guessing the card engine
     * @param player1name First player name
     * @param player2name Second player name
     * @return String of the player randomly choosen to start.
     */
    public static String start(String player1name, String player2name) {
        //Initiating the static engine variables
        randGen = new Random();
        player1 = new Player(player1name);
        player2 = new Player(player2name);
        bothHasPlayed = false;

        //the newest card is randomly 1-13
        newC = randGen.nextInt(CARDS) + 1;
        //player who plays first is either true (player1) or false(player2)
        firstPlays = randGen.nextBoolean();
        if (firstPlays) {
            return player1name;
        } else {
            return player2name;
        }
    }

    /**Draws the next card internally. OBS! rounds are counted only after guesses are made */
    public static void drawCard() {
        oldC = newC;
        newC = randGen.nextInt(CARDS) + 1; //1-13 randomly
        return;
    }

    /**Internal method for converting the @param card engine int for 
     * @return String char lowest to highest A23456789TJQK. */
    private static String engCard(int card) {
        if(card == 1){
            return "A";
        } else if(card == 10){
            return "T";
        } else if (card == 11) {
            return "J";
        } else if (card == 12) {
            return "Q";
        } else if (card == 13) {
            return "K";
        } else {
            return "" + card;
        }
    }

    /**Gets the internal int as a String for the new card
     * @return String value A23456789TJQK of the internal 1-13 int new value */
    public static String getNewEngC() {
        return engCard(newC);
    }

    /**Gets the internal int as a String for the old card
     * @return String value A23456789TJQK of the internal 1-13 int old value */
    public static String getOldEngC() {
        return engCard(oldC);
    }

    /**Ask if both players has played
     *  @return bothHasPlayed or not. */
    public static boolean both() {
        return bothHasPlayed;
    }

    /**Method for changing players and setting bothHasPlayed 
     * @return String instruction for the next player*/
    public static String nextPlayer(){
        firstPlays = !firstPlays;
        String whoIsNext;
        if(firstPlays){
            whoIsNext = Main.NOW + player1 + Main.PLAY;
        } else {
            whoIsNext = Main.NOW + player2 + Main.PLAY;
        }
        bothHasPlayed = true;
        return whoIsNext;
    }

    /**Guessing the card method where 
     * @param playerChoice is an int usually 1-3. OBS no internal error detection for other values
     * @return String if the guess was correct and which player should continue
    */
    public static String guess(int playerChoice) {
        if (playerChoice == 1) { //player guess the next card is higher
            Player.addRound();
            if (newC > oldC) {
                if (firstPlays) { //if the next card was correctly guessed to be higher
                    player1.addScore();
                    return Main.CORRECT + engCard(newC) + ". " + player1 + Main.CONT;
                } else {
                    player2.addScore();
                    return Main.CORRECT + engCard(newC) + ". " + player2 + Main.CONT;
                }
            } else { //if the next card was wrongly guessed to be higher
                firstPlays = !firstPlays;
                bothHasPlayed = true;
                if (firstPlays) {
                    return Main.WRONG + engCard(newC) + Main.LET + player1 + Main.PLAY;
                } else {
                    return Main.WRONG + engCard(newC) + Main.LET + player2 + Main.PLAY;
                }

            }
        } else if (playerChoice == 2) { //player guess the next card is lower
            Player.addRound();
            if (newC < oldC) { //if the next card was correctly guessed to be lower
                if (firstPlays) {
                    player1.addScore();
                    return Main.CORRECT + engCard(newC) + ". " + player1 + Main.CONT;
                } else {
                    player2.addScore();
                    return Main.CORRECT + engCard(newC) + ". " + player2 + Main.CONT;
                }
            } else { //if the next card was wrongly guessed to be lower
                firstPlays = !firstPlays;
                bothHasPlayed = true;
                if (firstPlays) {
                    return Main.WRONG + engCard(newC) + Main.LET + player1 + Main.PLAY;
                } else {
                    return Main.WRONG + engCard(newC) + Main.LET + player2 + Main.PLAY;
                }
            }
        } else {
            return ""; //usually third option continuation uncertain, both players have played needs to checked now.
        }
    }

    /**Checked who won or if draw and ask the other player if he wants to continue. 
     * @return String Ask the other player if he wants a rematch
    */
    public static String checkScores() {
        if (player1.getHiscore() == player2.getHiscore()) {
            return Main.DRAW;
        } else if (player1.getHiscore() > player2.getHiscore()) {
            firstPlays = false;
            return player1 + Main.WON + player2 + Main.REMATCH;
        } else {
            firstPlays = true;
            return player2 + Main.WON + player1 + Main.REMATCH;
        }
    }
}
