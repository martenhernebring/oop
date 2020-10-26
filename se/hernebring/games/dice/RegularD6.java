package se.hernebring.games.dice;

import java.util.concurrent.ThreadLocalRandom;

//import java.util.Random;

public class RegularD6 implements GameDie{

    private static final int SIDES = 6;
    // private Random randGen;

    public RegularD6() {
        // randGen = new Random();
    }

    public int getSides() {
        return SIDES;
    }

    public int roll() {
        // int result = randGen.nextInt(SIDES)+1;//standard 1-6
        int result = ThreadLocalRandom.current().nextInt(SIDES) + 1;// standard 1-6
        return result;
    }

    @Override
    public String getDescription() {
        return "en sex-sidig tärning";
    }
}
