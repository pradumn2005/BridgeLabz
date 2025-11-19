import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages employee salaries using Map<String, Double> for name -> salary.
 */
public class EmployeeSalaryDirectory {

    public static void main(String[] args) {
        Map<String, Double> salaryDirectory = new HashMap<>();

        // 1. Add employees with their salaries
        salaryDirectory.put("Alice", 60000.0);
        salaryDirectory.put("Bob", 75000.0);
        salaryDirectory.put("Charlie", 90000.0);
        salaryDirectory.put("David", 50000.0);
        salaryDirectory.put("Eve", 90000.0);
        salaryDirectory.put("Frank", 65000.0);

        System.out.println("--- Initial Salaries ---");
        System.out.println(salaryDirectory);

        // 2. Give a raise
        giveRaise(salaryDirectory, "Bob", 10); // 75000 * 1.10 = 82500.0
        giveRaise(salaryDirectory, "Alice", 5); // 60000 * 1.05 = 63000.0
        giveRaise(salaryDirectory, "NonExistent", 10); // Not found

        // 3. Print the average salary of all employees
        printAverageSalary(salaryDirectory);

        // 4. Print the name(s) of the highest-paid employee(s)
        printHighestPaid(salaryDirectory);
    }

    public static void giveRaise(Map<String, Double> directory, String employeeName, double percentage) {
        directory.computeIfPresent(employeeName, (name, currentSalary) -> {
            double raiseAmount = currentSalary * (percentage / 100.0);
            double newSalary = currentSalary + raiseAmount;
            System.out.printf("\nRaise for %s (%.1f%%). New Salary: %.2f%n", name, percentage, newSalary);
            return newSalary;
        });

        if (!directory.containsKey(employeeName)) {
            System.out.println("\nEmployee " + employeeName + " not found.");
        }
    }

    public static void printAverageSalary(Map<String, Double> directory) {
        if (directory.isEmpty()) {
            System.out.println("Cannot compute average: directory is empty.");
            return;
        }

        double totalSalary = directory.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();

        double average = totalSalary / directory.size();
        System.out.printf("\nAverage Salary of all %d employees: %.2f%n", directory.size(), average);
    }

    public static void printHighestPaid(Map<String, Double> directory) {
        if (directory.isEmpty()) {
            return;
        }

        // Find the maximum salary value
        double maxSalary = directory.values().stream()
            .max(Double::compare)
            .orElse(0.0); // Should not happen if not empty

        // Find all employees with that salary
        List<String> highestPaidEmployees = directory.entrySet().stream()
            .filter(entry -> entry.getValue().equals(maxSalary))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println("\n--- Highest Paid Employee(s) ---");
        System.out.printf("Highest Salary: %.2f%n", maxSalary);
        System.out.println("Employee(s): " + highestPaidEmployees);
    }
}
