package assignment2.suggestedsolutions;

public class Digit {

	private final int base;
	private int value = 0;

	public Digit(int base) {
		if (base <= 0) {
			throw new IllegalArgumentException("Cannot set base to a negative number.");
		}

		this.base = base;
	}

	public int getValue() {
		return this.value;
	}

	public int getBase() {
		return this.base;
	}

	public boolean increment() {
		this.value++;

		if (this.value == this.base) {
			this.value = 0;
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value, this.base).toUpperCase();
	}
}
