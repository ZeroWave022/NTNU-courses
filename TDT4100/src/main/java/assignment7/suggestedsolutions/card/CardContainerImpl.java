package assignment7.suggestedsolutions.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer {

	protected final List<Card> cards = new ArrayList<>();
	private final int maxCardCount;

	public CardContainerImpl(int max) {
		this.maxCardCount = max;
	}

	public int getMaxCardCount() {
		return this.maxCardCount;
	}

	@Override
	public int getCardCount() {
		return this.cards.size();
	}

	@Override
	public Card getCard(int i) {
		if (i < 0 || i >= this.getCardCount()) {
			throw new IllegalArgumentException(
					"Index " + i + " out of bounds for deck of size " + this.getCardCount());
		}

		return this.cards.get(i);
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
}
