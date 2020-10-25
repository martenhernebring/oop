package se.hernebring.card.suit;
public class Card {
    private Suit suit;
    private Rank rank;

    Card(Rank rank, Suit suit){
        this.suit=suit;
        this.rank=rank;
    }

    @Override
    public String toString() {
        return rank+" OF "+suit;
    }

    public Suit getSuit() {
        return suit;
    }
    
}
