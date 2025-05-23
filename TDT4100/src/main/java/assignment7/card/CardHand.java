package assignment7.card;

import java.util.Iterator;

import assignment5.Card;
import assignment5.CardContainerIterator;

public class CardHand extends CardContainerImpl {
    public CardHand(int maxCardCount) {
        super(maxCardCount);
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
