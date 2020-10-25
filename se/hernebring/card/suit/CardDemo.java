package se.hernebring.card.suit;
import java.util.ArrayList;
import java.util.List;

public class CardDemo {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>(52);
        Rank[] allRanks = Rank.values();
        Suit[] allSuits = Suit.values();
        for (Suit suit : allSuits) {
            int i = 1;
            for (Rank rank : allRanks) {
                Card currentCard = new Card(rank, suit);
                deck.add(currentCard);
                if (rank == Rank.TWO) {
                    System.out.print(currentCard + ".");
                } else {
                    System.out.print(currentCard + ", ");
                }
                if (i == 5) {
                    System.out.println();
                    i=1;
                } else {
                    i++;
                }
            }
            System.out.println("\n");
        }
    }

}
