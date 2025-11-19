import java.util.List;
import java.util.stream.Collectors;

public class PatientIDPrinter {

    // A static method used for demonstration
    public static void printId(int id) {
        System.out.println("Verified Patient ID: " + id);
    }

    public static void main(String[] args) {
        List<Patient> patients = List.of(
            new Patient(101, "Alice"),
            new Patient(102, "Bob"),
            new Patient(103, "Charlie")
        );

        System.out.println("--- Printing Patient IDs (Instance Method Reference) ---");
        // Method Reference: Patient::getId (Reference to an instance method of an arbitrary object)
        List<Integer> ids = patients.stream()
            .map(Patient::getId)
            .collect(Collectors.toList());
        
        ids.forEach(System.out::println);

        System.out.println("\n--- Printing IDs (Static Method Reference) ---");
        // Method Reference: PatientIDPrinter::printId (Reference to a static method)
        ids.forEach(PatientIDPrinter::printId);
    }
}
