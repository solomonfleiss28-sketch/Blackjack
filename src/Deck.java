import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {
                "Ace", "2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King"
        };

        for (String suit : suits) {
            for (String name : names) {
                cards.add(new Card(suit, name));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> shuffled = new ArrayList<>();

        while (cards.size() > 0) {
            int randomIndex = (int)(Math.random() * cards.size());
            shuffled.add(cards.get(randomIndex));
            cards.remove(randomIndex);
        }

        cards = shuffled;
    }

    public Card drawCard() {
        return cards.remove(0);
    }
}