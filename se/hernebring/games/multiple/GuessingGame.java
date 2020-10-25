package se.hernebring.games.multiple;
import java.util.InputMismatchException;

/** A simple game that let you guess the number 1-10 */
public class GuessingGame implements Game {
    /**
     * Instance variables: random generator, 1-10 random no, Strings for question,
     * clue and scanner for Swedish inputs
     */
    private int randNumber;
    public static final String QUESTION = "Gissa vilket tal jag tänker på? ";
    public static final String SUCCESS = "Hurra du lyckades!";
    private String clue;
    private static int score;

    /** Constructor creates a new Random object and generates a new random number */
    public GuessingGame() {
        randNumber = Utils.randGen.nextInt(10) + 1;
    }

    public void startaOm() {
        randNumber = Utils.randGen.nextInt(10) + 1;
        score = 1;
    }

    /**
     * @param guess int 1-10 to compare with random number
     * @return boolean true if guess was right otherwise a clue
     */
    public boolean guess(int guess) {
        if (guess == randNumber)
            return true;
        else if (guess > randNumber) {
            clue = "Talet jag söker är mindre än " + guess + ".";
        } else {
            clue = "Talet jag söker är större än " + guess + ".";
        }
        return false;
    }

    /** @return String clue to know how close you guessed */
    public String getClue() {
        return clue;
    }

    @Override
    public String play() {
        startaOm();
        while (true) {
            System.out.print(GuessingGame.QUESTION);
            Boolean guess = null;
            try {
                guess = guess(Utils.scan.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Skriv in ett heltal.");
                Utils.scan.next();
            }
            if(guess == null){
                continue;
            } else if (guess==true) {
                break;
            } else {
                score++;
                System.out.println(getClue());
            }
        }
        System.out.println(GuessingGame.SUCCESS);
        return "Det tog " + score + " gissningar att hitta rätt.";
    }

    @Override
    public String getName() {
        return "Gissa siffra";
    }
}
