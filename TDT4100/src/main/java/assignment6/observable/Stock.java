package assignment6.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String ticker;
    private double price;
    private List<StockListener> listeners = new ArrayList<>();

    public Stock(String ticker, double price) {
        if (ticker == null)
            throw new IllegalArgumentException("Ticker cannot be null");
        this.ticker = ticker;
        this.price = price;
    }

    public void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Stock price must be positive");

        listeners.stream().forEach(l -> l.stockPriceChanged(this, this.price, price));
        this.price = price;
    }

    public void addStockListener(StockListener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public void removeStockListener(StockListener listener) {
        listeners.remove(listener);
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public List<StockListener> getListeners() {
        return this.listeners;
    }
}
