package assignment7.solutions.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import assignment5.solutions.Card;
import assignment5.solutions.CardContainer;
import assignment5.solutions.CardContainerIterator;

public class CardContainerImpl implements CardContainer {

    protected List<Card> cards = new ArrayList<>();
    private int maxCardCount;

    public CardContainerImpl(int maxCardCount) {
        this.maxCardCount = maxCardCount;
    }

    public void addCard(Card card) {
        if (cards.size() == this.maxCardCount)
            throw new IllegalStateException("Cannot add more cards.");
        this.cards.add(card);
    }

    @Override
    public Card getCard(int index) {
        int cards = getCardCount();
        if (index > cards - 1)
            throw new IllegalArgumentException(String.format("There are only %d cards available.", cards));

        return this.cards.get(index);
    }

    @Override
    public int getCardCount() {
        return this.cards.size();
    }

    public int getMaxCardCount() {
        return this.maxCardCount;
    }

    @Override
    public Iterator<Card> iterator() {
        return new CardContainerIterator(this);
    }

}
