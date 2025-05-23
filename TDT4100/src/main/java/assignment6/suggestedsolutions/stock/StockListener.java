package assignment6.suggestedsolutions.stock;

public interface StockListener {

	void stockPriceChanged(Stock stock, double oldPrice, double newPrice);
}
