package assignment5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
    private Iterator<Double> iterator1;
    private Iterator<Double> iterator2;
    private Double default1;
    private Double default2;
    private BinaryOperator<Double> operator;

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
            BinaryOperator<Double> operator) {
        if (Arrays.asList(iterator1, iterator2, operator).contains(null))
            throw new IllegalArgumentException("No argument can be null");

        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.operator = operator;
    }

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1,
            Double default2,
            BinaryOperator<Double> operator) {
        if (Arrays.asList(iterator1, iterator2, operator).contains(null))
            throw new IllegalArgumentException("No argument can be null");

        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.default1 = default1;
        this.default2 = default2;
        this.operator = operator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator1.hasNext() && this.iterator2.hasNext() || this.iterator1.hasNext() && this.default2 != null
                || this.iterator2.hasNext() && this.default1 != null;
    }

    @Override
    public Double next() {
        if (!this.iterator1.hasNext() && default1 == null)
            throw new NoSuchElementException("iterator1 (" + this.iterator1 + ") ran out of elements");
        if (!this.iterator2.hasNext() && default2 == null)
            throw new NoSuchElementException("iterator2 (" + this.iterator2 + ") ran out of elements");

        Double num1 = this.iterator1.hasNext() ? this.iterator1.next() : this.default1;
        Double num2 = this.iterator2.hasNext() ? this.iterator2.next() : this.default2;

        return operator.apply(num1, num2);
    }

    public static void main(String[] args) {
        Iterator<Double> iterator1 = List.of(2.0, 3.0).iterator();
        Iterator<Double> iterator2 = List.of(5.0).iterator();

        BinaryOperator<Double> addition = (a, b) -> a + b;

        BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, null, 10.0,
                addition);

        binaryIterator.next(); // 7.0
        binaryIterator.hasNext(); // true
        binaryIterator.next(); // 13.0
        binaryIterator.hasNext(); // false
    }
}
