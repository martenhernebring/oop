package se.hernebring.games;
import java.util.Random;

public class GuessingGame {
    private static final Random randGen = new Random();
    private int randomNumber=randGen.nextInt(10)+1;
    private int tries = 0;

    private static int bestResult = Integer.MAX_VALUE;
    private static int worstResult = 0;

    public static final int CORRECT = 0;
    public static final int LOWER = -1;
    public static final int HIGHER = 1;
    public static final int ERROR = 2;

    public int getTries(){
        return tries;
    }

    public static int getBestResult(){
        return bestResult;
    }

    public static int getWorstResult(){
        return bestResult;
    }

/**@return 0 if they are the same, -1 if the guess is lower, +1 if the guess is higher, otherwise +2. */
    int check(int answer){
        if(answer>10||answer<1)
            return ERROR;
        tries++;
        if(answer==randomNumber){
            if(tries<bestResult)
                bestResult=tries;
            if(tries>worstResult)
                worstResult=tries;
            return CORRECT;
        }
        else if(answer>randomNumber)
            return LOWER;
        else return HIGHER;
    }
}