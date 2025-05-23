package assignment6.suggestedsolutions.stock;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class StockIndex implements StockListener {

	private final Collection<Stock> stocks = new HashSet<>();
	private final String name;

	public StockIndex(String name, Stock... stocks) {
		if (name == null) {
			throw new IllegalArgumentException("Name must be non-null");
		}

		this.name = name;
		Arrays.asList(stocks).forEach(stock -> this.addStock(stock));
	}

	public String getName() {
		return this.name;
	}

	public double getIndex() {
		return this.stocks.parallelStream().mapToDouble(Stock::getPrice).sum();
	}

	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		System.out.println(
				"Stock price changed: " + stock.getTicker() + " " + oldPrice + " -> " + newPrice);
	}

	public void addStock(Stock stock) {
		if (stock == null) {
			throw new IllegalArgumentException("Stock must be non-null");
		}

		this.stocks.add(stock);
		stock.addStockListener(this);
	}

	public void removeStock(Stock stock) {
		stock.removeStockListener(this);
		this.stocks.remove(stock);
	}
}
