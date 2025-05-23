package assignment5.suggestedsolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RPNCalc {

	private final Map<Character, BinaryOperator<Double>> binaryOperators = new HashMap<>();
	private final Stack<Double> operandStack = new Stack<>();

	// Extra task fields
	private final Map<Character, Supplier<Double>> suppliers = new HashMap<>();
	private final Map<Character, UnaryOperator<Double>> unaryOperators = new HashMap<>();

	public void push(double value) {
		this.operandStack.push(value);
	}

	public int getSize() {
		return this.operandStack.size();
	}

	public double peek(int n, double defaultValue) {
		if (n < 0 || n >= this.operandStack.size()) {
			return defaultValue;
		}
		return this.operandStack.get(this.operandStack.size() - n - 1);
	}

	public double peek(int n) {
		return this.peek(n, Double.NaN);
	}

	public double pop(double defaultValue) {
		if (this.operandStack.isEmpty()) {
			return defaultValue;
		}
		return this.operandStack.pop();
	}

	public double pop() {
		return this.pop(Double.NaN);
	}

	public void performOperation(char operation) {
		if (!this.binaryOperators.containsKey(operation)) {
			throw new UnsupportedOperationException("The given operation has not been added.");
		}

		double d2 = this.pop();
		double d1 = this.pop();
		this.push(this.binaryOperators.get(operation).apply(d1, d2));
	}

	public boolean addOperator(char op, BinaryOperator<Double> operator) {
		if (operator == null) {
			return false;
		}
		if (this.binaryOperators.containsKey(op)) {
			return false;
		}

		this.binaryOperators.put(op, operator);
		return true;
	}

	public void removeOperator(char op) {
		this.binaryOperators.remove(op);
	}

	@Override
	public String toString() {
		return String.format("[RPNCalc operators=%s]", this.binaryOperators);
	}

	/*
	 * EXTRA TASK
	 * 
	 * Below, two implementations of the extra tasks are shown. To separate the
	 * methods with equal
	 * names, Version 1 has a suffix of 1 to method names, and version 2 has a 2.
	 * 
	 * VERSION 1
	 * 
	 * This version only allows an operator to be added as one of binary, unary or
	 * supplier. This
	 * shifts the responsibility of handling missing numbers (Double.NaN) to the
	 * operators.
	 * 
	 * The result is that the operators become somewhat more complex, but the logic
	 * of this class is
	 * simpler and more general than Version 2 (below)
	 */

	public void performOperation1(char op) {
		if (this.binaryOperators.containsKey(op)) {
			double d2 = this.pop();
			double d1 = this.pop();
			this.push(this.binaryOperators.get(op).apply(d1, d2));
		} else if (this.unaryOperators.containsKey(op)) {
			double d = this.pop();
			this.push(this.unaryOperators.get(op).apply(d));
		} else if (this.suppliers.containsKey(op)) {
			this.push(this.suppliers.get(op).get());
		} else {
			throw new UnsupportedOperationException("The given operation has not been added.");
		}
	}

	private boolean containsOperator(char op) {
		return this.binaryOperators.containsKey(op) || this.unaryOperators.containsKey(op)
				|| this.suppliers.containsKey(op);
	}

	public boolean addOperator1(char op, BinaryOperator<Double> operator) {
		if (this.containsOperator(op)) {
			return false;
		}
		return this.addOperator(op, operator);
	}

	public boolean addOperator1(char op, UnaryOperator<Double> operator) {
		if (operator == null) {
			return false;
		}
		if (this.containsOperator(op)) {
			return false;
		}

		this.unaryOperators.put(op, operator);
		return true;
	}

	public boolean addOperator1(char op, Supplier<Double> operator) {
		if (operator == null) {
			return false;
		}
		if (this.containsOperator(op)) {
			return false;
		}

		this.suppliers.put(op, operator);
		return true;
	}

	public void removeOperator1(char op) {
		this.binaryOperators.remove(op);
		this.unaryOperators.remove(op);
		this.suppliers.remove(op);
	}

	/*
	 * VERSION 2
	 * 
	 * This version allows for multiple definitions for each operator, one for
	 * binary, one for
	 * unary, and one for suppliers. The system will always choose the operator that
	 * takes in the
	 * most amount of operands, as long as there is that many operands left in the
	 * stack. This lets
	 * the operator-definition simpler, as we don't need to handle NaNs anywhere.
	 * However, it also
	 * enforces the assumption that we always want to use the operator with most
	 * operands, which
	 * might not (but probably is) always be true
	 */

	public void performOperation2(char op) {
		if (this.binaryOperators.containsKey(op) && this.getSize() >= 2) {
			double d2 = this.pop();
			double d1 = this.pop();
			push(this.binaryOperators.get(op).apply(d1, d2));
		} else if (this.unaryOperators.containsKey(op) && this.getSize() >= 1) {
			double d = this.pop();
			this.push(this.unaryOperators.get(op).apply(d));
		} else if (suppliers.containsKey(op)) {
			this.push(this.suppliers.get(op).get());
		} else {
			throw new UnsupportedOperationException("Operation " + op
					+ " is not supported for at most " + this.getSize() + " operands.");
		}
	}

	public boolean addOperator2(char op, BinaryOperator<Double> operator) {
		// #putIfAbsent returns null if the given key is not associated with any value,
		// so we can
		// use this to check if it exists previously
		if (operator == null) {
			return false;
		}
		return this.binaryOperators.putIfAbsent(op, operator) == null;
	}

	public boolean addOperator2(char op, UnaryOperator<Double> operator) {
		if (operator == null) {
			return false;
		}
		return this.unaryOperators.putIfAbsent(op, operator) == null;
	}

	public boolean addOperator2(char op, Supplier<Double> operator) {
		if (operator == null) {
			return false;
		}
		return this.suppliers.putIfAbsent(op, operator) == null;
	}

	public void removeOperator2(char op, int numOperands) {
		if (numOperands == 0) {
			this.suppliers.remove(op);
		} else if (numOperands == 1) {
			this.unaryOperators.remove(op);
		} else if (numOperands == 2) {
			this.binaryOperators.remove(op);
		} else {
			throw new IllegalArgumentException("Number of operands must be 0, 1 or 2.");
		}
	}

	public void removeOperators2(char op) {
		this.binaryOperators.remove(op);
		this.unaryOperators.remove(op);
		this.suppliers.remove(op);
	}
}
