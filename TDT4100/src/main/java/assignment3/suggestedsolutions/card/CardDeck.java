package assignment3.suggestedsolutions.card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	private final List<Card> cards = new ArrayList<>();

	public CardDeck(int n) {
		if (n < 0 || n > 13) {
			throw new IllegalArgumentException("Illegal suit size " + n);
		}

		for (char suit : Card.SUITS) {
			for (int face = 1; face <= n; face++) {
				Card card = new Card(suit, face);
				this.cards.add(card);
			}
		}
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

	public void shufflePerfectly() {
		int halfSize = this.cards.size() / 2;

		for (int i = 0; i < halfSize; i++) {
			Card card = this.cards.remove(halfSize + i);
			this.cards.add(i * 2 + 1, card);
		}
	}

	@Override
	public String toString() {
		return String.format("[Deck cards=%s]", this.cards);
	}
}
