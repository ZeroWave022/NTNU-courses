package assignment5.solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CardComparator implements Comparator<Card> {
    private boolean aceFirst;
    private HashMap<Character, Integer> filterPriorities = new HashMap<>();

    public CardComparator(boolean aceFirst, char suit) {
        this.aceFirst = aceFirst;

        this.filterPriorities = new HashMap<>(Card.filterPriorities);
        if (suit != ' ')
            this.filterPriorities.put(suit, 5);
    }

    /**
     * @param aceFirst Whether the ace should be counted as 14 (true) or 1 (false)
     * @param suits    The 4 suits of cards, in order of priority descending from
     *                 highest to lowest.
     */
    public CardComparator(boolean aceFirst, List<Character> suits) {
        if (suits.size() != 4)
            throw new IllegalArgumentException("Suits list must be of size 4.");

        if (suits.stream().anyMatch(s -> !List.of('C', 'D', 'H', 'S').contains(s)))
            throw new IllegalArgumentException("Suits can only be exactly 'C', 'D', 'H' and 'S'");

        for (int i = 1; i < 5; i++)
            this.filterPriorities.put(suits.get(i - 1), i);
    }

    @Override
    public int compare(Card c1, Card c2) {
        int suitDifference = Integer.compare(filterPriorities.get(c1.getSuit()), filterPriorities.get(c2.getSuit()));
        if (suitDifference != 0)
            return suitDifference;

        int face1 = c1.getFace() == 1 && aceFirst ? 14 : c1.getFace();
        int face2 = c2.getFace() == 1 && aceFirst ? 14 : c2.getFace();
        return Integer.compare(face1, face2);
    }
}
