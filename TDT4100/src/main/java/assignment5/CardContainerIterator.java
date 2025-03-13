package assignment5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CardContainerIterator implements Iterator<Card> {
    private CardContainer container;
    private int i;

    public CardContainerIterator(CardContainer container) {
        this.container = container;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < container.getCardCount();
    }

    @Override
    public Card next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return container.getCard(i++);
    }
}
