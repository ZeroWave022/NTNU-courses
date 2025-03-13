package assignment5;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
    private StringGrid grid;
    private boolean rowFirst;
    private int currentRow;
    private int currentCol;

    public StringGridIterator(StringGrid grid, boolean rowFirst) {
        this.grid = grid;
        this.rowFirst = rowFirst;
    }

    @Override
    public boolean hasNext() {
        return this.currentRow < this.grid.getRowCount() && this.currentCol < this.grid.getColumnCount();
    }

    @Override
    public String next() {
        String elem = this.grid.getElement(currentRow, currentCol);

        if (rowFirst) {
            this.currentCol += 1;
            if (currentCol + 1 > grid.getColumnCount()) {
                currentCol = 0;
                currentRow++;
            }
        } else {
            this.currentRow += 1;
            if (currentRow + 1 > grid.getRowCount()) {
                currentRow = 0;
                currentCol++;
            }
        }

        return elem;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove strings from the grid");
    }

    public static void main(String[] args) {
        StringGrid stringGrid = new StringGridImpl(3, 3);
        stringGrid.setElement(0, 0, "a");
        stringGrid.setElement(0, 1, "b");
        stringGrid.setElement(0, 2, "c");
        stringGrid.setElement(1, 0, "d");
        stringGrid.setElement(1, 1, "e");
        stringGrid.setElement(1, 2, "f");
        // StringGridIterator iter = stringGrid.iterator();

        StringGridIterator iterator = new StringGridIterator(stringGrid, false);

        while (iterator.hasNext()) {
            String elem = iterator.next();
            System.out.println(elem);
        }
    }
}
