package assignment4.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardHandTest {

	private CardHand cardHand;

	@BeforeEach
	public void setup() {
		cardHand = new CardHand();
	}

	@Test
	@DisplayName("Sjekk at konstruktøren lager en tom CardHand")
	void testConstructor() {
		CardDeck deck = new CardDeck(2);
		deck.deal(cardHand, 3);
		CardHandTest.checkHand(cardHand, "C2,C1,D2");
	}

	@Test
	@DisplayName("Test deal- og play-metodene")
	void testDealPlay() {
		CardDeck deck = new CardDeck(2);
		deck.deal(cardHand, 3);
		CardHandTest.checkHand(cardHand, "C2,C1,D2");

		cardHand.play(1);
		CardHandTest.checkHand(cardHand, "C2,D2");

		cardHand.play(0);
		CardHandTest.checkHand(cardHand, "D2");

		cardHand.play(0);
		assertEquals(cardHand.getCardCount(), 0);
	}

	private static void checkHand(CardHand hand, String deckAsString) {
		String[] toStrings = deckAsString.split(",");
		assertEquals(toStrings.length, hand.getCardCount(), "Det var feil antall kort på hånda");

		int i = 0;

		for (String toString : toStrings) {
			Card card = hand.getCard(i);
			String cardString = String.valueOf(card.getSuit()) + card.getFace();
			assertEquals(toString, cardString, String.format(
					"Kortet på plass %d var feil. Hånda skulle inneholdt %s.", i + 1, toStrings));
			i++;
		}
	}
}
