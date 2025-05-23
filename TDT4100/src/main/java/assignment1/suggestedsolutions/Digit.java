package assignment1.suggestedsolutions;

public class Digit {

	private int base;
	private int value = 0;

	public Digit(int base) {
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
		return String.valueOf("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.value));

		// Can also use builtin:
		// return Integer.toString(this.value, this.base).toUpperCase();
	}

	public static void main(String[] args) {
		// Ekstraoppgave
		Digit digit1 = new Digit(10);
		Digit digit2 = new Digit(10);
		Digit digit3 = new Digit(10);

		boolean complete = false;

		while (!complete) {
			if (digit3.increment()) {
				if (digit2.increment()) {
					complete = digit1.increment();
				}
			}

			System.out.println("" + digit1 + digit2 + digit3);
		}
	}
}
