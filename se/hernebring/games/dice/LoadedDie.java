package se.hernebring.games.dice;

import java.util.concurrent.ThreadLocalRandom;

//import java.util.Random;

public class LoadedDie implements GameDie{

    private static final int SIDES = 6;
    // private Random randGen;

    public LoadedDie() {
        // randGen = new Random();
    }

    public int getSides() {
        return SIDES;
    }

    public int roll() {
        // int result = randGen.nextInt(SIDES+1)+1;//standard 1-7
        int result = ThreadLocalRandom.current().nextInt(SIDES+1) + 1;// standard 1-7
        if(result == 7){ //LoadedDie 6 occurs twice as often
            return 6;
        } else{
            return result;
        }
    }

    @Override
    public String getDescription() {
        return "en sex-sidig tärning som slår 6 dubbelt så ofta";
    }
}
