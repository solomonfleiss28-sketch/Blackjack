public class Card {

    private String suit;
    private String name;
    private int value;

    public Card(String suit, String name) {
        this.suit = suit;
        this.name = name;

        if (name.equals("Ace")) {value = 11;}
        else if (name.equals("Jack")) {value = 10;}
        else if (name.equals("Queen")) {value = 10;}
        else if (name.equals("King")) {value = 10;}
        else {value = Integer.parseInt(name);}
    }
    public String getSuit() {
        return suit;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }

    public String toString() {
        return name + " of " + suit;
    }
}
