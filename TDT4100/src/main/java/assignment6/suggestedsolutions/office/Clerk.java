package assignment6.suggestedsolutions.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {

	private final Printer printer;
	private int calculationCount = 0;

	public Clerk(Printer printer) {
		this.printer = printer;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		this.calculationCount++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		this.printer.printDocument(document, this);
	}

	@Override
	public int getTaskCount() {
		return this.calculationCount + this.printer.getPrintHistory(this).size();
	}

	@Override
	public int getResourceCount() {
		return 1;
	}
}
