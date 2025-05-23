package assignment6.solutions.observable;

public interface StockListener {
    void stockPriceChanged(Stock stock, double oldValue, double newValue);
}
