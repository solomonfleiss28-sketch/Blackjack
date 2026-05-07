public class Player {

    Hand hand;

    public Player(Deck deck) {
        hand = new Hand();

        hand.addCard(deck.drawCard());
        hand.addCard(deck.drawCard());
    }

    public void hit(Deck deck) {
        hand.addCard(deck.drawCard());
    }

    public void stand() {
        System.out.println("Stand.");
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public void printInfo() {
        hand.printHand();
        System.out.println("Value: " + hand.getValue());
    }
}