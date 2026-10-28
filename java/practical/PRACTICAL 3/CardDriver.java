import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // toString()
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Card))
            return false;

        Card c = (Card) obj;

        return rank.equals(c.rank) && suit.equals(c.suit);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}


// Driver class
public class CardDriver {

    public static void main(String[] args) {

        // Create Card array
        Card[] cards = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Clubs")
        };

        // Check each card with earlier cards
        for (int i = 0; i < cards.length; i++) {

            for (int j = 0; j < i; j++) {

                if (cards[i].equals(cards[j])) {

                    System.out.println(
                        "Duplicate found: " + cards[i]
                    );

                    return;
                }
            }
        }
    }
}