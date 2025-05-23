package assignment6.suggestedsolutions.stock;

import java.util.Collection;
import java.util.HashSet;

public class Stock {

	private final Collection<StockListener> listeners = new HashSet<>();
	private final String ticker;
	private double price;

	public Stock(String ticker, double price) {
		if (ticker == null) {
			throw new IllegalArgumentException("Ticker must not be null");
		}

		Stock.validatePrice(price);
		this.ticker = ticker;
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public String getTicker() {
		return this.ticker;
	}

	private static void validatePrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Stock price must be larger than zero");
		}
	}

	// Endringsmetoden kaller alle lytternes lyttermetode
	public void setPrice(double newPrice) {
		Stock.validatePrice(newPrice);
		double oldPrice = this.price;
		this.price = newPrice;

		if (newPrice != oldPrice) {
			this.firePriceChanged(oldPrice);
		}
	}

	public void addStockListener(StockListener listener) {
		this.listeners.add(listener);
	}

	public void removeStockListener(StockListener listener) {
		this.listeners.remove(listener);
	}

	// helper for notifying listeners
	// protected, so it may be called by subclasses
	protected void firePriceChanged(double oldPrice) {
		this.listeners.forEach(listener -> listener.stockPriceChanged(this, oldPrice, this.price));

		// Alternativt:
		// for (StockListener listener : listeners) {
		// listener.stockPriceChanged(this, oldPrice, this.price);
		// }
	}
}
