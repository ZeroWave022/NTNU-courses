package assignment6.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

    Collection<Employee> employees;

    Manager(Collection<Employee> employees) {
        if (employees == null || employees.size() == 0)
            throw new IllegalArgumentException("Employees collection cannot be empty.");
        this.employees = employees;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        return employees.stream()
                .min((e1, e2) -> e1.getTaskCount() - e2.getTaskCount())
                .get()
                .doCalculations(operation, value1, value2);
    }

    @Override
    public int getResourceCount() {
        return employees.stream().mapToInt(e -> e.getResourceCount()).sum() + 1;
    }

    @Override
    public int getTaskCount() {
        return employees.stream().mapToInt(e -> e.getTaskCount()).sum();
    }

    @Override
    public void printDocument(String document) {
        employees.stream()
                .min((e1, e2) -> e1.getTaskCount() - e2.getTaskCount())
                .get()
                .printDocument(document);
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        ArrayList<Employee> employees = new ArrayList<>(
                List.of(new Clerk(printer), new Clerk(printer), new Clerk(printer)));
        Manager manager = new Manager(employees);

        System.out.println("Our manager has: " + manager.getResourceCount() + "clerks.");

        Manager manager2 = new Manager(new ArrayList<>(employees));
        manager2.doCalculations((a, b) -> a + b, 1, 2);
        System.out.println("Our second manager has: " + manager.getResourceCount() + "clerks.");
    }
}
