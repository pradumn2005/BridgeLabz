import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Maps Employee ID -> Department Name using a HashMap<Integer, String>.
 */
public class EmployeeDepartmentMapping {

    public static void main(String[] args) {
        Map<Integer, String> employeeDeptMap = new HashMap<>();

        // 1. Add multiple employees
        employeeDeptMap.put(101, "HR");
        employeeDeptMap.put(102, "IT");
        employeeDeptMap.put(103, "HR");
        employeeDeptMap.put(104, "Marketing");
        employeeDeptMap.put(105, "IT");
        System.out.println("--- Initial Employee-Department Mapping ---");
        System.out.println(employeeDeptMap);

        // 2. Change department of an employee
        int employeeIdToChange = 103;
        String newDepartment = "Finance";
        employeeDeptMap.put(employeeIdToChange, newDepartment);
        System.out.println("\nChanged Dept for " + employeeIdToChange + " to " + employeeDeptMap.get(employeeIdToChange));

        // 3. Find all employees working in a given department (reverse lookup)
        findEmployeesInDepartment(employeeDeptMap, "IT");
        findEmployeesInDepartment(employeeDeptMap, "HR");
        findEmployeesInDepartment(employeeDeptMap, "Finance");

        // 4. Print total employees per department (grouping logic)
        countEmployeesPerDepartment(employeeDeptMap);
    }

    public static void findEmployeesInDepartment(Map<Integer, String> map, String department) {
        List<Integer> employeeIds = map.entrySet().stream()
            .filter(entry -> entry.getValue().equalsIgnoreCase(department))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println("\nEmployees in " + department + ": " + employeeIds);
    }

    public static void countEmployeesPerDepartment(Map<Integer, String> map) {
        // Use Streams and Collectors.groupingBy to group by the department (value)
        Map<String, Long> countPerDept = map.values().stream()
            .collect(Collectors.groupingBy(dept -> dept, Collectors.counting()));

        System.out.println("\n--- Total Employees Per Department ---");
        countPerDept.forEach((dept, count) ->
            System.out.println(dept + ": " + count + " employees")
        );
    }
}
