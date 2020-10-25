package se.hernebring.games;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        // we define the different moves as constant integers
        // to make the code more readable
        final int ROCK = 0;
        final int PAPER = 1;
        final int SCISSORS = 2;
        // to maintain proper randomness we do not want to
        // create a new random object in every loop.
        Random rand = new Random();
        // neither should the scanner be created more than once
        Scanner scanner = new Scanner(System.in);
        int playerWins = 0;
        int gameWins = 0;
        // we give the loop a name to be able to break out of it from inside
        // other statements that might contain break.
        gameLoop: while (true) {
            System.out.println("Vilket är ditt drag? (sten/sax/påse/sluta)");
            String moveString = scanner.nextLine();
            int move;
            // we use a switch to convert the string
            // to an int that is easier to compare
            switch (moveString) {
                case "sten":
                    move = ROCK;
                    break;
                case "påse":
                    move = PAPER;
                    break;
                case "sax":
                    move = SCISSORS;
                    break;
                case "sluta":
                    // jump out of outer while loop if we chose to quit
                    break gameLoop;
                default:
                    System.out.println("Felaktigt drag, försök igen.");
                    continue; // skip to the top of the loop again (it will check the condition)
            }
            int gameMove = rand.nextInt(3);
            String gameMoveString;
            // convert the random number into a string we can
            // print out. Use the named constants.
            switch (gameMove) {
                case ROCK:
                    gameMoveString = "sten";
                    break;
                case PAPER:
                    gameMoveString = "påse";
                    break;
                case SCISSORS:
                    gameMoveString = "sax";
                    break;
                default:
                    throw new RuntimeException("This should never happen!");
            }
            System.out.print("Datorn valde " + gameMoveString + ". ");
            if ((gameMove == ROCK && move == SCISSORS) || (gameMove == PAPER && move == ROCK)
                    || (gameMove == SCISSORS && move == PAPER)) {
                System.out.println("Datorn vann.");
                gameWins++;
            } else if ((move == ROCK && gameMove == SCISSORS) || (move == PAPER && gameMove == ROCK)
                    || (move == SCISSORS && gameMove == PAPER)) {
                System.out.println("Du vann.");
                playerWins++;
            } else {
                System.out.println("Det blev oavgjort...");
            }
        }
        System.out.printf("Du vann %d match(er), datorn vann %d match(er).\n", playerWins, gameWins);
        scanner.close();
    }
    
}