package se.hernebring.games;
import java.util.concurrent.ThreadLocalRandom;

//import java.util.Random;

public class GameDie {

    private static final int STANDARD = 6;

    private int sides;
    //private Random randGen;
    private double sum;
    private double rolls;

    public GameDie(){
        this(STANDARD);
    }

    public GameDie(int sides){
        this.sides=sides;
        //randGen = new Random();
        sum=0;
        rolls=0;
    }

    public int getSides(){
        return sides;
    }

    public int roll(){
        rolls++;
        //int result = randGen.nextInt(sides)+1;//standard 1-6
        int result = ThreadLocalRandom.current().nextInt(sides)+1;//standard 1-6
        sum += result;
        return result; 
    }

    public double average(){
        return sum/rolls;
    }
}
