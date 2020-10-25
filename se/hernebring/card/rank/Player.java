package se.hernebring.card.rank;

/**@author Mårten Hernebring, Niklas Johansson, Tom Karlsson, Anton Edwards, Erik Blidner, Henrik Buller
 * A simple player model for playing any game requiring name, score and rounds or similar.
 */
public class Player {
    //private instance variables for recording names, scores and total rounds.
    private String name; 
    private int hiscore = 0;
    private static int rounds = 0;

    /**Empty constructor */
    public Player(){
    }

    /**Simple constructor adding player 
     * @param name Name of the player*/
    public Player(String name){
        this.name= name;
    }

    /**Simply adds one to the player hiscore instance */
    public void addScore(){
        hiscore++;
    }

    /**Simply adds one to the total rounds */
    public static void addRound(){
        rounds++;
    }

    /**Simply changes or set player 
     * @param name instance */
    public void setName(String name) {
        this.name = name;
    }

    /**Simply get player 
     * @return int hiscore instance  */
    public int getHiscore() {
        return hiscore;
    }

    /**Simply get player  
     * @return int total rounds  */
    public static int getRounds() {
        return rounds;
    }

    /**Easier printing of player name by adding Instance to String. */
    @Override
    public String toString() {
        return name;
    }
    
}
