package assignment5;

import java.util.ArrayList;
import java.util.Iterator;

public class CardHand implements CardContainer {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card play(int n) {
        return this.cards.remove(n);
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

    @Override
    public Iterator<Card> iterator() {
        return new CardContainerIterator(this);
    }
}
