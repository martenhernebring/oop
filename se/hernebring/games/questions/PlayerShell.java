package se.hernebring.games.questions;
import java.util.Scanner;

public class PlayerShell {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        PlayerEngine player1 = new PlayerEngine();
        player1.setName(scan.nextLine());
        boolean toPlay=true;
        while (toPlay) {
            boolean askMore=true;
            while (askMore) {
                player1.play();
                String answer = scan.nextLine();
                askMore=player1.check(answer);
            }
            player1.quit();
            String toContinue= scan.nextLine();
            toPlay=player1.want(toContinue);
        }
        player1.bye();
        scan.close();
    }
}
