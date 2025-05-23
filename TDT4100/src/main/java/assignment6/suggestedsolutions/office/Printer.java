package assignment6.suggestedsolutions.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Printer {

	private final Map<Employee, Collection<String>> printHistories = new HashMap<>();

	public void printDocument(String document, Employee employee) {
		if (document == null || employee == null) {
			throw new IllegalArgumentException("Document and employee cannot be null");
		}

		this.printHistories.putIfAbsent(employee, new ArrayList<>());
		this.printHistories.get(employee).add(document);
	}

	public Collection<String> getPrintHistory(Employee employee) {
		return new ArrayList<>(this.printHistories.getOrDefault(employee, Collections.emptyList()));
	}
}
