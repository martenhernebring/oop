package se.hernebring.games.multiple;
public class WaitingGame implements Game {

    private static int randomNumber;
    private static int score;
    private static int games;

    WaitingGame() {
        score = games = 0;
        randomNumber = Utils.randGen.nextInt(20) + 1; // 1-20 nummer
    }

    void restart() {
        randomNumber = Utils.randGen.nextInt(20) + 1; // 1-20 nummer
    }

    static int timeScore(int diff) {
        games++;
        switch (diff) {
            case -5:
                score++;
                return 1;
            case -4:
                score += 2;
                return 2;
            case -3:
                score += 3;
                return 3;
            case -2:
                score += 4;
                return 4;
            case -1:
                score += 5;
                return 5;
            case 0:
                score += 10;
                return 10;
            case 1:
                score += 5;
                return 5;
            case 2:
                score += 4;
                return 4;
            case 3:
                score += 3;
                return 3;
            case 4:
                score += 2;
                return 2;
            case 5:
                score++;
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String getName() {
        return "Väntaspelet";
    }

    @Override
    public String play() {
        WaitingGame sg = new WaitingGame();
        String answer = "ja";
        do {
            System.out.println("Du ska trycka enter om " + randomNumber + " sekunder.");
            long timeBefore = System.currentTimeMillis();
            System.out.println(Utils.scan.nextLine());
            long timeNow = System.currentTimeMillis();
            int wait = (int) ((int) timeNow - timeBefore) / 1000;
            System.out.println("Du tryckte enter efter " + wait + " sekunder.");
            System.out.println("Du får " + timeScore(wait - randomNumber) + " poäng.");
            sg.restart();
            System.out.println("Vill du spela igen? (ja/nej)");
            answer = Utils.scan.nextLine().trim().toLowerCase();
        } while (answer.equals("ja"));
        String result="Du har spelat " + games + " omgångar och fått " + score + " poäng";
        return result;
    }
}
