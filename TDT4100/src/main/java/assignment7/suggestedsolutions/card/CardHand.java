package assignment7.suggestedsolutions.card;

public class CardHand extends CardContainerImpl {

	public CardHand(int max) {
		super(max);
	}

	public void addCard(Card card) {
		if (this.getCardCount() >= this.getMaxCardCount()) {
			throw new IllegalStateException("Too many cards");
		}

		this.cards.add(card);
	}

	public Card play(int i) {
		return this.cards.remove(i);
	}

	@Override
	public String toString() {
		return String.format("[CardHand cards=%s]", this.cards);
	}
}
