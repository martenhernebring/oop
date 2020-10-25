package se.hernebring.card.suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        Rank[] allRanks = Rank.values();
        Suit[] allSuits = Suit.values();
        int size = allRanks.length * allSuits.length;
        deck = new ArrayList<Card>(size);
        for (Suit suit : allSuits) {
            for (Rank rank : allRanks) {
                Card currentCard = new Card(rank, suit);
                deck.add(currentCard);
            }
        }
        Collections.shuffle(deck);
    }

    public Card nextCard() {
        return deck.remove(size() - 1);
    }

    public int size() {
        return deck.size();
    }

}
