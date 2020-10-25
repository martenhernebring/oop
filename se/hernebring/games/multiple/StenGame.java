package se.hernebring.games.multiple;
/** A simple rook, scissors and bag game */
public class StenGame implements Game {
    /** Class constants */
    public static final String SLUTA = "SLUTA";
    public static final String STEN = "STEN";
    public static final String SAX = "SAX";
    public static final String PASE = "PASE";
    public static final String QUESTION = "Vilket är ditt drag? (sten/sax/påse/sluta)";

    /**
     * Instance variables number of wins and losses vs computer, random gen, and
     * comp choice
     */
    public static int win = 0, lose = 0;
    private String computer;
    private String quit;

    public String cheat() {
        return computer;
    }

    public void starta() {
        int randomNumber = Utils.randGen.nextInt(3) + 1; // 1-3 nummer
        switch (randomNumber) {
            case 1:
                computer = STEN;
                break;
            case 2:
                computer = SAX;
                break;
            case 3:
                computer = PASE;
                break;
            default:
                computer = SLUTA;// error in random generator
        }
    }

    public String play(String human) {
        human = human.toUpperCase();
        switch (human) {
            case SLUTA:
                quit = "Du vann " + win + " match(er), datorn vann " + lose + " match(er).";
                return "quit";
            case STEN:
                if (computer.equals(SAX)) {
                    win++;
                    return "Datorn valde sax. Du vann";
                } else if (computer.equals(PASE)) {
                    lose++;
                    return "Datorn valde påse. Datorn vann";
                }
                return "Ni båda valde sten. Ingen vann";
            case SAX:
                if (computer.equals(PASE)) {
                    win++;
                    return "Datorn valde påse. Du vann";
                } else if (computer.equals(STEN)) {
                    lose++;
                    return "Datorn valde sten. Datorn vann";
                }
                return "Ni båda valde sax. Ingen vann";
            default:
                if (computer.equals(STEN)) {
                    win++;
                    return "Datorn valde sten. Du vann";
                } else if (computer.equals(SAX)) {
                    lose++;
                    return "Datorn valde sax. Datorn vann";
                }
                return "Ni båda valde påse. Ingen vann";
        }
    }

    @Override
    public String getName() {
        return "Sten-Sax-Påse";
    }

    @Override
    public String play() {
        while (true) {
            starta();
            // System.out.println(ss.cheat()); Uncomment to cheat
            System.out.println(StenGame.QUESTION);
            String choice = Utils.scan.next().trim();
            String play = play(choice);
            System.out.println(play);
            if (play.equals("quit")) {
                return quit;
            }
        }
    }

}
