package assignment6.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {

    private Printer printer;
    private int calculations;

    public Clerk(Printer printer) {
        if (printer == null)
            throw new IllegalArgumentException("Printer cannot be null");
        this.printer = printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        this.calculations++;
        return operation.apply(value1, value2);
    }

    @Override
    public int getResourceCount() {
        return 1;
    }

    @Override
    public int getTaskCount() {
        return this.calculations + this.printer.getPrintHistory(this).size();
    }

    @Override
    public void printDocument(String document) {
        this.printer.printDocument(document, this);
    }
}
