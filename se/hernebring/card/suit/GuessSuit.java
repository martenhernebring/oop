package se.hernebring.card.suit;
import java.util.Scanner;

public class GuessSuit {
    private static final int EMPTY_DECK = 0;
    public static void main(String[] args) {
        Deck deck = new Deck();

        if(args != null){
            customize(deck, args[0]);
        }
        
        try (Scanner scan = new Scanner(System.in)) {
            while (deck.size() > EMPTY_DECK) {
                System.out.print("Guess the next suit (enter to quit): ");
                System.out.flush();
                String guess;
                guess = scan.nextLine().trim();
                if (guess.equals("")) {
                    break;
                } else {
                    Card card = deck.nextCard();
                    if (card.getSuit().toString().toLowerCase().equals(guess)) {
                        System.out.printf("Correct, the card was %s.\n", card.toString());
                    } else {
                        System.out.printf("Wrong, the card was %s.\n", card.toString());
                    }
                }
            }
        }
        if (deck.size() <= EMPTY_DECK) {
            System.out.println("No more cards in the deck.");
        }
        System.out.println("Quitting, have a nice day!");
    }

    private static void customize(Deck deck, String argument) {
        final int STANDARD = deck.size();
        int custom = STANDARD;
        try {
            custom = Integer.parseInt(argument.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("Ej tillåtet argument. Endast nummer mellan 0-52 tillåtet");
            System.exit(1);
        }
        if(custom > STANDARD || custom < EMPTY_DECK){
            System.out.println("Fel nummer. Endast argument mellan 0-52 tillåtet");
            System.exit(1);
        }
        for (int card = 1; card <= STANDARD - custom; card++) {
            deck.nextCard();
        }
    }
}
