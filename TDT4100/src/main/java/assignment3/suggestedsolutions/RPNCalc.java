package assignment3.suggestedsolutions;

import java.util.Stack;

public class RPNCalc {

	// Could also use a List, but would need to implement methods manually
	private final Stack<Double> operandStack = new Stack<>();

	public void push(double value) {
		this.operandStack.push(value);
	}

	public int getSize() {
		return this.operandStack.size();
	}

	public double peek(int n) {
		if (n < 0 || n >= this.operandStack.size()) {
			return Double.NaN;
		}
		return this.operandStack.get(this.operandStack.size() - n - 1);
	}

	public double pop() {
		return this.pop(Double.NaN);
	}

	public double pop(double defaultValue) {
		if (this.operandStack.isEmpty()) {
			return defaultValue;
		}
		return this.operandStack.pop();
	}

	public void performOperation(char operation) {
		double d1;
		double d2;

		// Could use a switch statement for simplicity, but this falls outside the
		// course material

		if (operation == '+') {
			// pop two operands and push the sum, missing values default to 0.0
			d1 = this.pop(0.0);
			d2 = this.pop(0.0);
			this.push(d2 + d1);
		} else if (operation == '-') {
			// pop two operands and push the difference, missing values default to 0.0
			d1 = this.pop(0.0);
			d2 = this.pop(0.0);
			this.push(d2 - d1);
		} else if (operation == '*') {
			// pop two operands and push the product, missing values default to 1.0
			d1 = this.pop(1.0);
			d2 = this.pop(1.0);
			this.push(d2 * d1);
		} else if (operation == '/') {
			// pop two operands and push the quotient, missing values default to 1.0
			d1 = this.pop(1.0);
			d2 = this.pop(1.0);
			this.push(d2 / d1);
		} else if (operation == '~') {
			// swap the two topmost values, by popping them and pushing them in reverse
			// order
			d1 = this.pop(0.0);
			d2 = this.pop(0.0);
			this.push(d1);
			this.push(d2);
		} else if (operation == '%') {
			// remainder
			d1 = this.pop(1.0);
			d2 = this.pop(1.0);
			this.push(d2 % d1);
		} else if (operation == '|') {
			// absolute value
			d1 = this.pop(0.0);
			this.push(Math.abs(d1));
		} else if (operation == 'v') {
			// square root
			d1 = this.pop(0.0);
			this.push(Math.sqrt(d1));
		} else if (operation == '^') {
			// power
			d1 = this.pop(1.0);
			d2 = this.pop(1.0);
			this.push(Math.pow(d2, d1));
		} else if (operation == '_') {
			// floor
			d1 = this.pop(0.0);
			this.push(Math.floor(d1));
		} else if (operation == '=') {
			// compare
			d1 = this.pop(0.0);
			d2 = this.pop(0.0);
			this.push(Double.compare(d2, d1));
		} else if (operation == '<') {
			// less than
			d1 = this.pop(0.0);
			d2 = this.pop(0.0);
			this.push(d2 < d1 ? 1.0 : 0.0);
		} else if (operation == '>') {
			// greater than
			d1 = this.pop(0.0);
			d2 = this.pop(0.0);
			this.push(d2 > d1 ? 1.0 : 0.0);
		} else if (operation == '?') {
			// signum
			d1 = this.pop(0.0);
			this.push(Math.signum(d1));
		} else if (operation == 'p' || operation == 'π') {
			// pi
			d1 = Math.PI;
			this.push(d1);
		} else if (operation == 'e') {
			// e
			d1 = Math.E;
			this.push(d1);
		} else {
			throw new IllegalArgumentException("Unknown operation " + operation);
		}
	}

	@Override
	public String toString() {
		return String.format("[RPNCalc operandStack=%s]", this.operandStack);
	}
}
