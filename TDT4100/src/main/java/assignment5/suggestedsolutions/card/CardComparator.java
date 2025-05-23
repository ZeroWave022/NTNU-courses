package assignment5.suggestedsolutions.card;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	private final boolean aceIsHighest;
	private final String suitOrder;

	// suitOrder is part of the voluntary extra task
	public CardComparator(boolean aceIsHighest, char trumph, String suitOrder) {
		this.aceIsHighest = aceIsHighest;

		if (trumph == ' ') {
			this.suitOrder = suitOrder;
		} else {
			// Make sure the trumph is last, so that it is considered "best". This means we
			// don't
			// need to store the trumph anywhere
			this.suitOrder = suitOrder.replace(String.valueOf(trumph), "") + trumph;
		}
	}

	public CardComparator(boolean aceIsHighest, char trumph) {
		this(aceIsHighest, trumph, "CDHS");
	}

	public CardComparator(boolean aceIsHighest, String suitOrder) {
		this(aceIsHighest, ' ', suitOrder);
	}

	private int getFace(Card card) {
		if (card.getFace() == 1 && this.aceIsHighest) {
			return 14;
		}
		return 1;
	}

	@Override
	public int compare(Card card1, Card card2) {
		int diff = Integer.compare(this.suitOrder.indexOf(card1.getSuit()),
				this.suitOrder.indexOf(card2.getSuit()));

		if (diff != 0) {
			return diff;
		}
		return Integer.compare(this.getFace(card1), this.getFace(card2));
	}
}
