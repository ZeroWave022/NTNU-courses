package assignment5.suggestedsolutions.stringgrid;

import java.util.Iterator;

public class StringGridImpl implements StringGrid, Iterable<String> {

	private final String[][] elements;

	public StringGridImpl(int rows, int columnCount) {
		if (rows <= 0 || columnCount <= 0) {
			throw new IllegalArgumentException("Row/column count should not be less than 1");
		}

		this.elements = new String[rows][columnCount];
	}

	@Override
	public int getRowCount() {
		return this.elements.length; // Length of first array will be the amount of rows
	}

	@Override
	public int getColumnCount() {
		return this.elements[0].length; // We can look at any column array to find column count
	}

	@Override
	public String getElement(int row, int column) {
		this.validateGridCoordinates(row, column);
		return this.elements[row][column];
	}

	@Override
	public void setElement(int row, int column, String element) {
		this.validateGridCoordinates(row, column);
		this.elements[row][column] = element;
	}

	// from Iterable<String>
	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this, true);
	}

	private void validateGridCoordinates(int row, int column) {
		if (row < 0 || row >= this.getRowCount() || column < 0 || column >= this.getColumnCount()) {
			throw new IllegalArgumentException("Illegal grid coordinates, " + row + "," + column
					+ ", for a grid of size " + this.getRowCount() + "," + this.getColumnCount());
		}
	}
}
