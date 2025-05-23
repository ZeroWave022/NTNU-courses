package assignment5.suggestedsolutions.card;

import java.util.Iterator;

public interface CardContainer extends Iterable<Card> {
	/**
	 * @return the number of cards within this CardContainer
	 */
	int getCardCount();

	/**
	 * Get a card at the given index.
	 * 
	 * @param i the index.
	 * @return the card at the provided index, starting at 0.
	 * @throws IllegalArgumentException when the index i is out of bounds
	 */
	Card getCard(int i);

	// Not part of the assignment to add this. This allows us to iterate over any
	// card container
	// without explicitly calling new CardContainerIterator
	@Override
	default Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
}
