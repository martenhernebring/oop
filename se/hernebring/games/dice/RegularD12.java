package se.hernebring.games.dice;

import java.util.concurrent.ThreadLocalRandom;

//import java.util.Random;

public class RegularD12 implements GameDie{

    private static final int SIDES = 12;
    // private Random randGen;

    public RegularD12() {
        // randGen = new Random();
    }

    public int getSides() {
        return SIDES;
    }

    public int roll() {
        // int result = randGen.nextInt(SIDES)+1;//standard 1-12
        int result = ThreadLocalRandom.current().nextInt(SIDES) + 1;// standard 1-12
        return result;
    }

    @Override
    public String getDescription() {
        return "en tolv-sidig tärning";
    }
}
