package assignment6.solutions.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
    Map<Employee, ArrayList<String>> employeeHistory = new HashMap<>();

    public void printDocument(String document, Employee employee) {
        if (document == null || employee == null)
            throw new IllegalArgumentException("Neither document nor employee can be null.");
        System.out.println(document);
        ArrayList<String> history = employeeHistory.get(employee);
        if (history != null) {
            history.add(document);
        } else {
            employeeHistory.put(employee, new ArrayList<>(List.of(document)));
        }
    }

    public List<String> getPrintHistory(Employee employee) {
        return employeeHistory.get(employee) != null ? new ArrayList<>(employeeHistory.get(employee))
                : new ArrayList<>();
    }
}
