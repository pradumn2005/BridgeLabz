import java.util.List;
import java.util.stream.Collectors;

public class EmployeeNameConverter {

    public static void main(String[] args) {
        List<String> employeeNames = List.of("john doe", "jane smith", "alice johnson");

        System.out.println("Original Names:");
        employeeNames.forEach(System.out::println);

        // Method Reference: String::toUpperCase (Reference to an instance method of an arbitrary object of a particular type)
        List<String> uppercaseNames = employeeNames.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("\nUppercase Names for HR Letter:");
        uppercaseNames.forEach(System.out::println);
    }
}
