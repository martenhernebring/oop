package se.hernebring.games.dice;

import java.util.Scanner;

public class DiceGame {
    static GameDie[] dice = { new RegularD6(), new LoadedDie(), new RegularD12() };

    public static void main(String[] args) {
        String player1 = "spelare ett", player2 = "spelare två";
        try (Scanner scan = new Scanner(System.in)) {
            GameDie die = chooseDie(scan, player1);
            int p1 = playerTurn(scan, player1, die);
            die = chooseDie(scan, player2);
            int p2 = playerTurn(scan, player2, die);
            if (p1 > p2) {
                System.out.println("Spelare ett vann!");
            } else if (p2 > p1) {
                System.out.println("Spelare två vann!");
            } else {
                System.out.println("Det blev oavgjort!");
            }
        }
    }

    private static GameDie chooseDie(Scanner scan, String name) {
        while (true) {
            System.out.printf("Vilken tärning vill %s använda?\n", name);
            for (GameDie die : dice) {
                System.out.println(die.getDescription());
            }
            String answer = scan.nextLine();
            for (GameDie die : dice) {
                if (answer.equals(die.getDescription())){
                    return die;
                }
            }
        }
    }

    private static int playerTurn(Scanner scan, String name, GameDie die) {
        int roll = die.roll();
        System.out.printf("Nu skall %s slå med %s.%n", name, die.getDescription());
        System.out.printf("Du slog %d.%n", roll);
        System.out.println("Vill du slå om? J/N");
        String answer = scan.nextLine();
        if (answer.trim().toLowerCase().equals("j")) {
            roll = die.roll();
            System.out.printf("Du slog nu %d.%n", roll);
        }
        return roll;
    }
}