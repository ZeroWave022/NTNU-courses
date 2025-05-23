package assignment5.suggestedsolutions;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {

	private final BinaryOperator<Double> operator;
	private final Double default1;
	private final Double default2;
	private final Iterator<Double> iterator1;
	private final Iterator<Double> iterator2;

	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
			Double default1, Double default2, BinaryOperator<Double> operator) {
		if (iterator1 == null || iterator2 == null || operator == null) {
			throw new IllegalArgumentException("Arguments cannot be null");
		}

		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.operator = operator;
	}

	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
			BinaryOperator<Double> operator) {
		this(iterator1, iterator2, null, null, operator);
	}

	@Override
	public boolean hasNext() {
		if (this.iterator1.hasNext() && this.iterator2.hasNext()) {
			return true;
		}
		if (this.iterator1.hasNext()) {
			return this.default2 != null;
		}
		return this.iterator2.hasNext() && this.default1 != null;
	}

	@Override
	public Double next() {
		if (!this.hasNext()) {
			throw new IllegalStateException("Iterator has no next element!");
		}

		double next1 = this.iterator1.hasNext() ? this.iterator1.next() : this.default1;
		double next2 = this.iterator2.hasNext() ? this.iterator2.next() : this.default2;
		return this.operator.apply(next1, next2);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove is not supported");
	}
}
