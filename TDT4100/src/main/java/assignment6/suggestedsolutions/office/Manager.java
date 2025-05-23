package assignment6.suggestedsolutions.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

	private final List<Employee> employees;
	private int nextDelegate = 0;

	public Manager(Collection<Employee> employees) {
		if (employees == null || employees.isEmpty()) {
			throw new IllegalArgumentException("A Manager must have someone to delegate to!");
		}

		this.employees = new ArrayList<>(employees);
	}

	private Employee getTaskDelegate() {
		return this.employees.get(this.nextDelegate % this.employees.size());
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		this.nextDelegate++;
		return this.getTaskDelegate().doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		this.nextDelegate++;
		this.getTaskDelegate().printDocument(document);
	}

	@Override
	public int getTaskCount() {
		return this.employees.parallelStream().mapToInt(Employee::getTaskCount).sum();

		// Alternativt:
		// this.employees.parallelStream().mapToInt(employee ->
		// employee.getTaskCount()).sum();

		// Tradisjonell metode:
		// int task = 0;
		// for(Employee e: employees) {
		// task += e.getTaskCount();
		// }
		// return task;

	}

	@Override
	public int getResourceCount() {
		return 1 + this.employees.parallelStream().mapToInt(Employee::getResourceCount).sum();

		// Alternativt:
		// 1 + this.employees.parallelStream().mapToInt(employee ->
		// employee.getResourceCount()).sum();

		// Tradisjonell metode:
		// int sum = 1;
		// for (Employee employee : employees) {
		// sum += employee.getResourceCount();
		// }
		// return sum;
	}
}
