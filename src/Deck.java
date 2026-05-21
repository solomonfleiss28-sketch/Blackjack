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

        int i = 0;
        while (i < suits.length) {
            String suit = suits[i];
            int j = 0;
            while (j < names.length) {
                String name = names[j];
                Card card = new Card(suit, name);
                cards.add(card);
                j = j + 1;}
            i = i + 1;}}

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