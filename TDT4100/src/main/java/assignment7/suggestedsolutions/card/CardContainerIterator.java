package assignment7.suggestedsolutions.card;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {

	private final CardContainer container;
	private int pos = 0;

	public CardContainerIterator(CardContainer container) {
		this.container = container;
	}

	@Override
	public boolean hasNext() {
		return this.pos < this.container.getCardCount();
	}

	@Override
	public Card next() {
		return this.container.getCard(this.pos++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"CardContainerIterator does not not support remove");
	}
}
