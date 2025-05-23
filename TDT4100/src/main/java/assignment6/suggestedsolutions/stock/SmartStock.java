package assignment6.suggestedsolutions.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartStock extends Stock {

	// Illustrate the use of two different techniques for associating data to a
	// listener

	// Two lists, where items are associated by index/position
	private final List<StockListener> intervalListeners = new ArrayList<>();
	// Two doubles for each listener
	private final List<Double> intervals = new ArrayList<>();

	// Map from listener to a double array (with two values)
	private final Map<StockListener, double[]> differenceListeners = new HashMap<>();

	public SmartStock(String ticker, double price) {
		super(ticker, price);
	}

	public void addStockListener(StockListener listener, double min, double max) {
		// Double array remembers min and max
		this.intervalListeners.add(listener);
		this.intervals.add(min);
		this.intervals.add(max);
	}

	public void addStockListener(StockListener listener, double difference) {
		// Double array remembers difference and last reported price (oldPrice)
		this.differenceListeners.put(listener, new double[] { difference, this.getPrice() });
	}

	public void removeStockListener(StockListener listener) {
		super.removeStockListener(listener);
		this.intervalListeners.remove(listener);
		this.differenceListeners.remove(listener);
	}

	// Hjelpemetode for å oppdatere lyttere
	@Override
	protected void firePriceChanged(double oldPrice) {
		super.firePriceChanged(oldPrice);

		// handle interval listeners
		for (int i = 0; i < this.intervalListeners.size(); i++) {
			StockListener listener = this.intervalListeners.get(i);

			// use associated double values
			double min = this.intervals.get(i * 2);
			double max = this.intervals.get(i * 2 + 1);
			double newPrice = this.getPrice();

			if (newPrice < min || newPrice > max) {
				listener.stockPriceChanged(this, oldPrice, newPrice);
			}
		}

		// handle difference listeners
		for (StockListener listener : this.differenceListeners.keySet()) {
			double[] diffOldPrice = this.differenceListeners.get(listener);
			double newPrice = this.getPrice();
			double difference = diffOldPrice[0];
			double lastReportedPrice = diffOldPrice[1];

			if (Math.abs(newPrice - lastReportedPrice) > difference) {
				// store back the price to use as oldPrice the next time
				diffOldPrice[1] = newPrice;
				listener.stockPriceChanged(this, lastReportedPrice, newPrice);
			}
		}
	}
}
