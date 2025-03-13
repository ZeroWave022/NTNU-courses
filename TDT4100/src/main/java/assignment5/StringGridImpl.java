package assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.IntStream;

public class StringGridImpl implements StringGrid {
    private int rows;
    private int columns;
    private ArrayList<ArrayList<String>> grid;

    public StringGridImpl(int rows, int columns) {
        if (rows < 0 || columns < 0)
            throw new IllegalArgumentException("Neither rows or colums can be 0 or less");

        this.rows = rows;
        this.columns = columns;

        this.grid = new ArrayList<>(IntStream.range(0, rows)
                .mapToObj(_ -> new ArrayList<>(Collections.nCopies(this.columns, (String) null))).toList());

        // Alternatively, using a for loop:
        // this.grid = new ArrayList<>();
        // for (int i = 0; i < rows; i++) {
        // ArrayList<String> emptyColumn = new ArrayList<>(IntStream.range(0,
        // columns).mapToObj(_ -> "").toList());
        // this.grid.add(emptyColumn);
        // }
    }

    @Override
    public int getColumnCount() {
        return this.columns;
    }

    @Override
    public String getElement(int row, int column) {
        return this.grid.get(row).get(column);
    }

    @Override
    public int getRowCount() {
        return this.rows;
    }

    @Override
    public void setElement(int row, int column, String element) {
        this.grid.get(row).set(column, element); // col - 1?
    }

    @Override
    public Iterator<String> iterator() {
        return new StringGridIterator(this, true);
    }
}
