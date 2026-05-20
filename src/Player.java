public class Player {

    public Hand hand;

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

    public void printInfo() {
        System.out.println(hand.getCards());
    }
}