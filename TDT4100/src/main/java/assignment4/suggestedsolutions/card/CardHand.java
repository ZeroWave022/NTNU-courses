package assignment4.suggestedsolutions.card;

import java.util.ArrayList;
import java.util.List;

public class CardHand {

	private final List<Card> cards = new ArrayList<>();

	public void addCard(Card card) {
		if (card == null) {
			throw new IllegalArgumentException("Card cannot be null");
		}

		this.cards.add(card);
	}

	public int getCardCount() {
		return this.cards.size();
	}

	public Card getCard(int i) {
		if (i < 0 || i >= this.getCardCount()) {
			throw new IllegalArgumentException(
					"Index " + i + " out of bounds for deck of size " + this.getCardCount());
		}

		return this.cards.get(i);
	}

	public Card play(int i) {
		if (i < 0 || i >= this.getCardCount()) {
			throw new IllegalArgumentException(
					"Index " + i + " out of bounds for deck of size " + this.getCardCount());
		}

		return this.cards.remove(i);
	}

	@Override
	public String toString() {
		return String.format("[CardHand cards=%s]", this.cards);
	}
}
