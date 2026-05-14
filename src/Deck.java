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
        for (int i = 0; i < 100; i++) {

            int card1 = (int)(Math.random() * 52);
            int card2 = (int)(Math.random() * 52);

            Card first = cards.get(card1);
            Card second = cards.get(card2);

            Card one = cards.get(card1);
            Card two = cards.get(card2);
        }
    }

    public Card drawCard() {
        return cards.remove(0);
    }
}