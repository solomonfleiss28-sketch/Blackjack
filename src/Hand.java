import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(int index) {
        return cards.remove(index);
    }

    public int getValue() {
        int total = 0;
        int i;

        for (i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            total = total + c.value;
        }

        return total;
    }
}