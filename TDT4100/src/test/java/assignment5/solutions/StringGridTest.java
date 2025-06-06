package assignment5.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringGridTest {

	private StringGrid grid;

	@BeforeEach
	public void setUp() {
		grid = new StringGridImpl(2, 3);
	}

	@Test
	@DisplayName("Test størrelsen")
	public void testSize() {
		assertEquals(2, grid.getRowCount(), "Antall rader var feil");
		assertEquals(3, grid.getColumnCount(), "Antall kolonner var feil");
	}

	@Test
	@DisplayName("Sjekk at setElementet setter riktig rute")
	public void testGrid() {
		grid.setElement(0, 0, "0, 0");
		grid.setElement(0, 1, "0, 1");
		grid.setElement(0, 2, "0, 2");
		grid.setElement(1, 0, "1, 0");
		grid.setElement(1, 1, "1, 1");
		grid.setElement(1, 2, "1, 2");

		assertEquals("0, 0", grid.getElement(0, 0));
		assertEquals("0, 1", grid.getElement(0, 1));
		assertEquals("0, 2", grid.getElement(0, 2));
		assertEquals("1, 0", grid.getElement(1, 0));
		assertEquals("1, 1", grid.getElement(1, 1));
		assertEquals("1, 2", grid.getElement(1, 2));
	}

	@Test
	@DisplayName("Sjekk elementene i rutenettet med bortover først")
	public void testGridIteratorRowMajor() {
		StringGridIterator iterator = new StringGridIterator(grid, true);

		grid.setElement(0, 0, "0, 0");
		grid.setElement(0, 1, "0, 1");
		grid.setElement(0, 2, "0, 2");
		grid.setElement(1, 0, "1, 0");
		grid.setElement(1, 1, "1, 1");
		grid.setElement(1, 2, "1, 2");

		assertTrue(iterator.hasNext());

		assertEquals("0, 0", iterator.next());
		assertTrue(iterator.hasNext());

		assertEquals("0, 1", iterator.next());
		assertTrue(iterator.hasNext());

		assertEquals("0, 2", iterator.next());
		assertTrue(iterator.hasNext());

		assertEquals("1, 0", iterator.next());
		assertTrue(iterator.hasNext());

		assertEquals("1, 1", iterator.next());
		assertTrue(iterator.hasNext());

		// False after going through last one
		assertEquals("1, 2", iterator.next());
		assertFalse(iterator.hasNext());
	}

	@Test
	@DisplayName("Sjekk elementene i rutenettet med nedover først")
	public void testGridIteratorColumnMajor() {
		StringGridIterator iterator = new StringGridIterator(grid, false);

		grid.setElement(0, 0, "0, 0");
		grid.setElement(0, 1, "0, 1");
		grid.setElement(0, 2, "0, 2");
		grid.setElement(1, 0, "1, 0");
		grid.setElement(1, 1, "1, 1");
		grid.setElement(1, 2, "1, 2");

		assertTrue(iterator.hasNext());

		assertEquals("0, 0", iterator.next(), "En rute var feil");
		assertTrue(iterator.hasNext(), "Feil antall ruter i rutenettet");

		assertEquals("1, 0", iterator.next(), "En rute var feil");
		assertTrue(iterator.hasNext(), "Feil antall ruter i rutenettet");

		assertEquals("0, 1", iterator.next(), "En rute var feil");
		assertTrue(iterator.hasNext(), "Feil antall ruter i rutenettet");

		assertEquals("1, 1", iterator.next(), "En rute var feil");
		assertTrue(iterator.hasNext(), "Feil antall ruter i rutenettet");

		assertEquals("0, 2", iterator.next(), "En rute var feil");
		assertTrue(iterator.hasNext(), "Feil antall ruter i rutenettet");

		// False after going through last one
		assertEquals("1, 2", iterator.next());
		assertFalse(iterator.hasNext(), "Feil antall ruter i rutenettet");
	}
}
