public class Card {

    String suite;
    String namei;

    public Card(String suit, String name) {
        suite =  suit;
        namei = name;
    }

    public String toString() {
        return namei + " of " + suite;
    }
}
