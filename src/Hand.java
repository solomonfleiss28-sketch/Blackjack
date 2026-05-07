import java.util.ArrayList;

class Hand {
    ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public void printHand() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    public int getValue() {
        int total = 0;

        for (Card c : cards) {
            String name = c.namei;

            if (name.equals("Jack") || name.equals("Queen") || name.equals("King")) {
                total = total + 10;
            } else if (name.equals("Ace")) {
                total = total + 11;
            } else {
                total = total + Integer.parseInt(name);
            }
        }

        return total;
    }
}