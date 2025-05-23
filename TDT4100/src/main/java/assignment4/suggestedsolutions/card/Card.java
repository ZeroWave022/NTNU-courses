package assignment4.suggestedsolutions.card;

import java.util.List;

public class Card {

	public static final List<Character> SUITS = List.of('S', 'H', 'D', 'C');

	private final char suit;
	private final int face;

	public Card(char suit, int face) {
		if (!Card.SUITS.contains(suit)) {
			throw new IllegalArgumentException("Illegal suit " + suit);
		}
		if (face < 1 || face > 13) {
			throw new IllegalArgumentException("Illegal face " + face);
		}

		this.suit = suit;
		this.face = face;
	}

	public char getSuit() {
		return this.suit;
	}

	public int getFace() {
		return this.face;
	}

	@Override
	public String toString() {
		return String.format("%s%d", this.suit, this.face);
	}
}
