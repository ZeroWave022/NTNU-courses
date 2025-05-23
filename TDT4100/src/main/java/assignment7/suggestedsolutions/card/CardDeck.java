package assignment7.suggestedsolutions.card;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CardDeck extends CardContainerImpl {

	public CardDeck(int n) {
		super(52);

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

	public void deal(CardHand hand, int handSize) {
		for (int i = 0; i < handSize; i++) {
			hand.addCard(this.cards.remove(this.cards.size() - 1));
		}
	}

	public void shufflePerfectly() {
		int halfSize = this.cards.size() / 2;

		for (int i = 0; i < halfSize; i++) {
			Card card = this.cards.remove(halfSize + i);
			this.cards.add(i * 2 + 1, card);
		}
	}

	public List<Card> getCards(Predicate<Card> predicate) {
		return this.cards.stream().filter(predicate).collect(Collectors.toList());
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
