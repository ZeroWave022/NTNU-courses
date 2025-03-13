package assignment5;

public interface CardContainer extends Iterable<Card> {
    int getCardCount();

    Card getCard(int n);
}
