package assignment5.solutions;

public interface CardContainer extends Iterable<Card> {
    int getCardCount();

    Card getCard(int n);
}
