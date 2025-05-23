package assignment7.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import assignment5.Card;
import assignment5.CardContainerIterator;

public class CardDeck extends CardContainerImpl {
    public CardDeck(int n) {
        super(52);
        if (n < 0 || n > 13)
            throw new IllegalArgumentException("Invalid card amount");

        for (char suit : List.of('S', 'H', 'D', 'C')) {
            for (int i = 0; i < n; i++) {
                this.cards.add(new Card(suit, i + 1));
            }
        }
    }

    public int getCardCount() {
        return this.cards.size();
    }

    public Card getCard(int index) {
        int cards = getCardCount();
        if (index > cards - 1)
            throw new IllegalArgumentException(String.format("There are only %d cards available.", cards));

        return this.cards.get(index);
    }

    public void shufflePerfectly() {
        int cards = getCardCount();
        List<Card> part1 = this.cards.subList(0, cards / 2);
        List<Card> part2 = this.cards.subList(cards / 2, cards);
        List<Card> shuffled = new ArrayList<Card>();

        for (int i = 0; i < part1.size(); i++) {
            shuffled.add(part1.get(i));
            shuffled.add(part2.get(i));
        }

        this.cards = new ArrayList<Card>(shuffled);
    }

    public void deal(CardHand hand, int n) {
        for (int i = 0; i < n; i++) {
            hand.addCard(this.cards.get(this.cards.size() - 1));
            this.cards.removeLast();
        }
    }

    public boolean hasCard(Predicate<Card> predicate) {
        if (predicate == null)
            throw new IllegalArgumentException("Predicate must not be null");
        return this.cards.stream().anyMatch(predicate);
    }

    public int getCardCount(Predicate<Card> predicate) {
        if (predicate == null)
            throw new IllegalArgumentException("Predicate must not be null");
        return this.cards.stream().filter(predicate).toList().size();
    }

    public List<Card> getCards(Predicate<Card> predicate) {
        if (predicate == null)
            throw new IllegalArgumentException("Predicate must not be null");
        return this.cards.stream().filter(predicate).toList();
    }

    @Override
    public Iterator<Card> iterator() {
        return new CardContainerIterator(this);
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck(5);
        List<Card> filteredCards = deck.getCards(c -> c.getSuit() == 'H');
        System.out.println(filteredCards);
    }
}
