package assignment6.observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import assignment4.StopWatch;

public class StockIndex implements StockListener {
    private String name;
    private List<Stock> stocks;
    private double index;

    public StockIndex(String name, Stock... stocks) {
        if (name == null || Arrays.asList(stocks).contains(null))
            throw new IllegalArgumentException("Neither name or stocks can be null");
        this.name = name;
        this.stocks = new ArrayList<>(List.of(stocks));
        this.stocks.stream().forEach(s -> s.addStockListener(this));
        this.index = this.stocks.stream().mapToDouble(s -> s.getPrice()).sum();
    }

    public void addStock(Stock stock) {
        if (stock == null)
            throw new IllegalArgumentException("Stock cannot be null");
        if (this.stocks.contains(stock))
            return;
        this.stocks.add(stock);
        stock.addStockListener(this);
        this.index += stock.getPrice();
    }

    public void removeStock(Stock stock) {
        if (!this.stocks.contains(stock))
            return;
        this.stocks.remove(stock);
        stock.removeStockListener(this);
        this.index -= stock.getPrice();
    }

    public double getIndex() {
        return index;
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        this.index += newValue - oldValue;
    }

    public static void main(String[] args) {
        Stock aapl = new Stock("AAPL", 200);
        Stock msft = new Stock("MSFT", 450);
        StockIndex index = new StockIndex("My index", aapl, msft);

        Stock eqnr = new Stock("EQNR", 180);
        Stock nhy = new Stock("NHY", 70);
        StockIndex index2 = new StockIndex("Norwegian index", eqnr, nhy);
    }
}
