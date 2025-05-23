package assignment3.solutions;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public CardDeck(int n) {
        if (n < 0 || n > 13)
            throw new IllegalArgumentException("Invalid card amount");

        for (char suit : List.of('S', 'H', 'D', 'C')) {
            for (int i = 0; i < n; i++) {
                cards.add(new Card(suit, i + 1));
            }
        }
    }

    public int getCardCount() {
        return this.cards.size();
    }

    public Card getCard(int index) {
        int cards = getCardCount();
        if (index > cards - 1)
            throw new IllegalArgumentException(String.format("There are only %d cards available.", cards));

        return this.cards.get(index);
    }

    public void shufflePerfectly() {
        int cards = getCardCount();
        List<Card> part1 = this.cards.subList(0, cards / 2);
        List<Card> part2 = this.cards.subList(cards / 2, cards);
        List<Card> shuffled = new ArrayList<Card>();

        for (int i = 0; i < part1.size(); i++) {
            shuffled.add(part1.get(i));
            shuffled.add(part2.get(i));
        }

        this.cards = new ArrayList<Card>(shuffled);
    }
}
