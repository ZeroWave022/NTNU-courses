package assignment5.suggestedsolutions.card;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck implements CardContainer {

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

	public void deal(CardHand cardHand, int n) {
		if (n < 0 || n > this.getCardCount()) {
			throw new IllegalArgumentException("Illegal card count " + n);
		}
		if (cardHand == null) {
			throw new IllegalArgumentException("Card hand cannot be null");
		}

		for (int i = 0; i < n; i++) {
			cardHand.addCard(this.cards.remove(this.cards.size() - 1));
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

	// methods using Predicate<Card>

	public List<Card> getCards(Predicate<Card> predicate) {
		if (predicate == null) {
			throw new IllegalArgumentException("Predicate cannot be null");
		}

		// Streams solution:
		// return this.cards.stream().filter(predicate).collect(Collectors.toList());

		// Manual solution
		List<Card> matchingCards = new ArrayList<>();

		for (Card card : this.cards) {
			if (predicate.test(card)) {
				matchingCards.add(card);
			}
		}

		return matchingCards;
	}

	public int getCardCount(Predicate<Card> predicate) {
		return this.getCards(predicate).size();
	}

	public boolean hasCard(Predicate<Card> predicate) {
		return this.getCardCount(predicate) > 0;
	}

	@Override
	public String toString() {
		return String.format("[CardDeck cards=%s]", this.cards);
	}
}
