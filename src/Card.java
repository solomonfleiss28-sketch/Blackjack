public class Card {

    String suite;
    String namei;
    int value;

    public Card(String suit, String name) {
        suite = suit;
        namei = name;

        if (name == ("Ace")) {
            value = 1;
        } else if (name == ("Jack") && name == ("Queen") && name == ("King")) {
            value = 10;
        } else {
            value = Integer.parseInt(name);
        }
    }

    public String toString() {
        return namei + " of " + suite;
    }
}