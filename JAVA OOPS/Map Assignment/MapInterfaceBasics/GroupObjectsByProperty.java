import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a simple Employee object with a name and department.
 */
class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

/**
 * Groups a list of Employee objects by their department using a Map.
 * Example: Employees: [Alice (HR), Bob (IT), Carol (HR)] -> Output: HR: [Alice, Carol], IT: [Bob].
 */
public class GroupObjectsByProperty {

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        // Use the Stream API's Collectors.groupingBy for a concise solution
        return employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR"),
            new Employee("David", "IT"),
            new Employee("Eve", "Marketing")
        );

        Map<String, List<Employee>> groupedByDept = groupByDepartment(employees);
        System.out.println("Employees List: " + employees);
        System.out.println("\nEmployees Grouped by Department:");
        groupedByDept.forEach((dept, list) ->
            System.out.println(dept + ": " + list)
        );
    }
}
