package assignment6.solutions.observable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartStock extends Stock {
    private Map<StockListener, List<Double>> intervals = new HashMap<>();
    private Map<StockListener, List<Double>> priceHistory = new HashMap<>();

    public SmartStock(String ticker, double price) {
        super(ticker, price);
    }

    public void addStockListener(StockListener listener, double min, double max) {
        if (intervals.containsKey(listener))
            return;
        intervals.put(listener, List.of(min, max));
    }

    public void addStockListener(StockListener listener, double difference) {
        if (priceHistory.containsKey(listener))
            return;
        priceHistory.put(listener, List.of(difference, super.getPrice()));
    }

    public void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Stock price must be positive");

        super.getListeners().stream().forEach(l -> l.stockPriceChanged(this, super.getPrice(), price));

        intervals.forEach((listener, range) -> {
            if (price < range.get(0) || price > range.get(1))
                listener.stockPriceChanged(this, super.getPrice(), price);
        });

        priceHistory.forEach((listener, history) -> {
            if (price - history.get(1) > history.get(0))
                listener.stockPriceChanged(this, history.get(1), price);
        });
        super.setPrice(price);
    }
}
