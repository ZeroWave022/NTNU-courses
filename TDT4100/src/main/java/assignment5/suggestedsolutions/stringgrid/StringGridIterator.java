package assignment5.suggestedsolutions.stringgrid;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

	private final boolean rowMajor;
	private final StringGrid grid;
	private int column = 0;
	private int row = 0;

	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.grid = grid;
		this.rowMajor = rowMajor;
	}

	@Override
	public boolean hasNext() {
		return this.row < this.grid.getRowCount() && this.column < this.grid.getColumnCount();
	}

	@Override
	public String next() {
		String element = this.grid.getElement(row, column);

		if (this.rowMajor) {
			if (++this.column >= this.grid.getColumnCount()) {
				this.column = 0;
				this.row++;
			}
		} else {
			if (++this.row >= this.grid.getRowCount()) {
				this.row = 0;
				this.column++;
			}
		}

		return element;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("GridIterator does not not support remove");
	}
}
