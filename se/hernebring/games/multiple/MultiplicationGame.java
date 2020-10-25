package se.hernebring.games.multiple;
public class MultiplicationGame implements Game {

    private int fact1;
    private int fact2;
    private int result;
    private int correct;
    private int tries;
    private long milliSeconds;
    private final int EASY = 1;
    private final int MEDIUM = 2;
    private final int HARD = 3;
    private int difficulty;
    private MultiplicationGame mg;

    public MultiplicationGame() {
    }

    public MultiplicationGame(int difficulty) {
        this.difficulty = difficulty;
        correct = tries = 0;
        milliSeconds = 0;
        if (this.difficulty == EASY) {
            fact1 = Utils.randGen.nextInt(3) + 2; // 2-5 nummer
            fact2 = Utils.randGen.nextInt(3) + 2; // 2-5 nummer
        } else if (this.difficulty == HARD) {
            fact1 = Utils.randGen.nextInt(3) + 2; // 2-5 nummer
            fact2 = Utils.randGen.nextInt(3) + 2; // 2-5 nummer
        } else { // MEDIUM default
            fact1 = Utils.randGen.nextInt(8) + 2; // 2-10 nummer
            fact2 = Utils.randGen.nextInt(8) + 2; // 2-10 nummer
        }

        result = fact1 * fact2;
        System.out.println("Svara 0 för att avsluta.");
        System.out.println("Vad blir " + fact1 + " x " + fact2);
    }

    void timeSpent(long timeNow, long timeBefore) {
        milliSeconds += (int) ((int) timeNow - timeBefore);
    }

    void restart() {
        if (difficulty == EASY) {
            fact1 = Utils.randGen.nextInt(3) + 2; // 2-5 nummer
            fact2 = Utils.randGen.nextInt(3) + 2; // 2-5 nummer
        } else if (difficulty == HARD) {
            fact1 = Utils.randGen.nextInt(97) + 2; // 2-99 nummer
            fact2 = Utils.randGen.nextInt(97) + 2; // 2-99 nummer
        } else if (difficulty == MEDIUM) { // MEDIUM default
            fact1 = Utils.randGen.nextInt(8) + 2; // 2-10 nummer
            fact2 = Utils.randGen.nextInt(8) + 2; // 2-10 nummer
        } else
            System.out.println("ERROR");
        result = fact1 * fact2;
        System.out.println("Vad blir " + fact1 + " x " + fact2);
    }

    String getResults() {
        double snitt = milliSeconds / tries;
        int seconds = (int) milliSeconds / 1000;
        return "Du svarade på " + tries + " frågor. Du hade " + correct + " rätt. Totalt tog det " + seconds
                + " sekunder att svara \n(" + snitt / 1000 + " sekunder i snitt per fråga).";
    }

    boolean checkAnswer(int ans) {
        tries++;
        if (ans == result) {
            correct++;
            System.out.println("Rätt.");
            return true;
        } else {
            System.out.println("Fel.");
            return false;
        }
    }

    @Override
    public String play() {
        int spel = 0;
        do {
            System.out.println("Välj nivå: (1) Lätt (2) Medel (3) Jättesvår.");
            spel = Utils.scan.nextInt();
        } while (spel <= 0 || spel > 3);
        mg = new MultiplicationGame(spel);
        long timeBefore = System.currentTimeMillis();
        int answer = Utils.scan.nextInt();
        long timeNow = System.currentTimeMillis();
        while (answer != 0) {
            mg.timeSpent(timeNow, timeBefore);
            timeNow = System.currentTimeMillis();
            mg.checkAnswer(answer);
            mg.restart();
            timeBefore = System.currentTimeMillis();
            answer = Utils.scan.nextInt();
        }
        return mg.getResults();
    }

    @Override
    public String getName() {
        return "Multiplikationsspel";
    }
}
