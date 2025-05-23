package assignment5.solutions;

import java.util.List;
import java.util.Map;

/**
 * The {@code Card} class is a so-called value-based class, which is coded in
 * such a way that its
 * objects cannot be modified after they are created. A {@code Card} object has
 * a suit and a face.
 */
public class Card implements Comparable<Card> {
    public static final Map<Character, Integer> filterPriorities = Map.of(
            'C', 1, 'D', 2, 'H', 3, 'S', 4);
    private char suit;
    private int face;

    /**
     * The constructor of the {@code Card} class initializes the suit and face of
     * the card with the
     * first and second arguments, respectively.
     * 
     * @param suit the suit of the card, one of {@code 'S'} (spades), {@code 'H'}
     *             (hearts),
     *             {@code 'D'} (diamonds), or {@code 'C'} (clubs)
     * @param face the face of the card, an integer between {@code 1} (ace) and
     *             {@code 13} (king)
     *             (both inclusive)
     * @throws IllegalArgumentException if the suit or face is illegal
     * 
     * @see {@link CardTest#testConstructor}
     */
    public Card(char suit, int face) {
        this.validateValues(suit, face);
        this.suit = suit;
        this.face = face;
    }

    private boolean validateValues(char suit, int face) throws IllegalArgumentException {
        if (!List.of('S', 'H', 'D', 'C').contains(suit)) {
            throw new IllegalArgumentException("Incorrect char suit provided.");
        }

        if (face < 1 || face > 13) {
            throw new IllegalArgumentException("Incorrect face integer provided");
        }

        return true;
    }

    /**
     * @return the suit of the card
     */
    public char getSuit() {
        return this.suit;
    }

    /**
     * @return the face of the card
     */
    public int getFace() {
        return this.face;
    }

    /**
     * @return the value of the card of the form {@code <suit><face>}. For example,
     *         the ace of
     *         spades should return {@code "S1"}
     * 
     * @see {@link CardTest#testToString}
     */
    @Override
    public String toString() {
        return this.suit + String.valueOf(this.face);
    }

    @Override
    public int compareTo(Card o) {
        int suitDifference = Integer.compare(filterPriorities.get(this.suit), filterPriorities.get(o.suit));

        if (suitDifference != 0) {
            return suitDifference;
        }

        return Integer.compare(this.face, o.face);

    }

    public static void main(String[] args) {
        Card card = new Card('S', 1);
        System.out.println(card);
    }
}
