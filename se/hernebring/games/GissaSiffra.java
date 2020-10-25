package se.hernebring.games;
import java.util.Random;

/**A simple game that let you guess the number 1-10 */
public class GissaSiffra {
    /**Instance variables: random generator, 1-10 random no, Strings for question, clue and end*/
    private Random rand;
    private int randNumber;
    public static final String QUESTION= "Gissa vilket tal jag tänker på? ";
    public static final String SUCCESS= "Hurra du lyckades!";
    private String clue;

    /**Constructor creates a new Random object and generates a new random number*/
    GissaSiffra(){
        rand=new Random();
        randNumber=rand.nextInt(10)+1;
    }

    public void startaOm(){
        randNumber=rand.nextInt(10)+1;
    }

    /**@param guess int 1-10 to compare with random number 
     * @return boolean true if guess was right otherwise a clue */
    public boolean guess(int guess){
        if(guess==randNumber) return true;
        else if(guess>randNumber){
            clue="Talet jag söker är mindre än "+guess+".";
        } else{
            clue="Talet jag söker är större än "+guess+".";
        }
        return false;
    }
    
    /**@return String clue to know how close you guessed */
    public String getClue(){
        return clue;
    }
}
