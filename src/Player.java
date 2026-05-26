import java.util.ArrayList;

public class Player {

    private Hand hand;

    public Player() {
        hand = new Hand();
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void hit(Deck deck) {
        hand.addCard(deck.drawCard());
    }

    public ArrayList<Card> getCards() {
        return hand.getCards(); // controlled access
    }

    public void printInfo() {
        System.out.println(hand.getCards());
    }
}