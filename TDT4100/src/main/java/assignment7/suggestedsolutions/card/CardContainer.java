package assignment7.suggestedsolutions.card;

public interface CardContainer extends Iterable<Card> {

	int getCardCount();

	Card getCard(int i);
}
