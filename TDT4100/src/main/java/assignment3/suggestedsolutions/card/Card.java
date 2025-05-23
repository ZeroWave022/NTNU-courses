package assignment3.suggestedsolutions.card;

import java.util.List;

public class Card {

	private final char suit;
	private final int face;

	/**
	 * The set of suits in decreasing order. If you are curious about final and
	 * static you can read
	 * about them below. Note that (ab)using static is generally bad OOP practice.
	 * 
	 * @see final: https://www.w3schools.com/java/ref_keyword_final.asp.
	 * @see static: https://www.w3schools.com/java/ref_keyword_static.asp.
	 */
	public static final List<Character> SUITS = List.of('S', 'H', 'D', 'C');

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
