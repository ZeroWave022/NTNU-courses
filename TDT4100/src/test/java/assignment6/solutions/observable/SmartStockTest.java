package assignment6.solutions.observable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SmartStockTest {

	private SmartStock stock;
	private double oldPrice;
	private double newPrice;

	// Brukes for å sjekke at lyttere funker
	private double oldPriceListener;
	private double newPriceListener;

	private void setPriceForListener(double oldPrice, double newPrice) {
		oldPriceListener = oldPrice;
		newPriceListener = newPrice;
	}

	private void setPriceCheckListener(String contextMessage, double newPrice,
			double expectedOldPrice, double expectedNewPrice) {
		// Oppdatere prisen
		this.oldPrice = this.newPrice;
		this.newPrice = newPrice;
		stock.setPrice(newPrice);

		// Sjekke at lytter har mottatt endring
		assertEquals(expectedOldPrice, this.oldPriceListener,
				contextMessage + " -> Teste gammel pris for lytter etter å ha oppdatert pris fra "
						+ oldPrice + " til " + newPrice);
		assertEquals(expectedNewPrice, this.newPriceListener,
				contextMessage + " -> Teste ny pris for lytter etter å ha oppdatert pris fra "
						+ oldPrice + " til " + newPrice);
	}

	@BeforeEach
	public void setUp() {
		stock = new SmartStock("APPL", 110.0);
	}

	@Test
	@DisplayName("Teste kontruktør")
	public void testConstructor() {
		assertEquals("APPL", stock.getTicker(), "Teste ticker");
		assertEquals(110.0, stock.getPrice(), "Teste aksjeprisen");
	}

	@Test
	@DisplayName("Negativ aksjepris gir feilmelding")
	public void testSetNegativePrice() {
		assertThrows(IllegalArgumentException.class, () -> {
			stock.setPrice(-20.0);
		}, "Teste å sette negativ aksjepris");
	}

	@Test
	@DisplayName("Aksjepris lik null gir feilmelding")
	public void testSetZeroPrice() {
		assertThrows(IllegalArgumentException.class, () -> {
			stock.setPrice(0);
		}, "Teste å sette aksjepris lik null");
	}

	@Test
	@DisplayName("Legge til lytter")
	public void testStockListener() {
		StockListener listener = (Stock stock, double oldPrice, double newPrice) -> this
				.setPriceForListener(oldPrice, newPrice);
		stock.addStockListener(listener);

		this.setPriceCheckListener("Lytter på alt", 118.0, 110.0, 118.0);
		assertEquals(118.0, stock.getPrice(), "Teste aksjepris etter å ha oppdatert pris");

		this.setPriceCheckListener("Lytter på alt", 121.0, 118.0, 121.0);
		assertEquals(121.0, stock.getPrice(), "Teste aksjepris etter å ha oppdatert pris 2 ganger");
	}

	@Test
	@DisplayName("Teste lytter på prisintervall")
	public void testIntervalListener() {
		StockListener listener = (Stock stock, double oldPrice, double newPrice) -> this
				.setPriceForListener(oldPrice, newPrice);
		stock.addStockListener(listener, 110.0, 120.0);

		// Pris innenfor intervallet gir ingen beskjed til lytter
		this.setPriceCheckListener("Lytter på prisintervall", 118.0, 0.0, 0.0);
		assertEquals(118.0, stock.getPrice(), "Teste aksjepris etter å ha oppdatert pris");

		// Pris utenfor intervallet gir beskjed til lytter
		this.setPriceCheckListener("Lytter på prisintervall", 121.0, 118.0, 121.0);
		assertEquals(121.0, stock.getPrice(),
				"Teste aksjepris etter å ha oppdatert pris for andre gang");

		// Pris innenfor intervallet gir ingen beskjed til lytter (forventende verdier
		// forblir det de var)
		this.setPriceCheckListener("Lytter på prisintervall", 115.0, 118.0, 121.0);
		assertEquals(115.0, stock.getPrice(),
				"Teste aksjepris etter å ha oppdatert pris for tredje gang");
	}

	@Test
	@DisplayName("Teste lytter på differanse")
	public void testDifferenceListener() {
		StockListener listener = (Stock stock, double oldPrice, double newPrice) -> this
				.setPriceForListener(oldPrice, newPrice);
		stock.addStockListener(listener, 10.0);

		// Pris med differanse mindre enn 10 varsler ikke lytter
		this.setPriceCheckListener("Lytter på differanse", 118.0, 0.0, 0.0);
		assertEquals(118.0, stock.getPrice());

		// Pris med differanse større enn 10 varsler lytter
		this.setPriceCheckListener("Lytter på differanse", 121.0, 110.0, 121.0);
		assertEquals(121.0, stock.getPrice());

		// Pris med differanse mindre enn 10 varsler ikke lytter (forventende verdier
		// forblir det de var)
		this.setPriceCheckListener("Lytter på differanse", 115.0, 110.0, 121.0);
		assertEquals(115.0, stock.getPrice());
	}
}
