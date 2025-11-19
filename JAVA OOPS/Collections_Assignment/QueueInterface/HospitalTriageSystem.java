import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents a patient in the Triage system.
 * Severity: Higher number means higher priority.
 */
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Sev:" + severity + ")";
    }
}

/**
 * Simulates a hospital triage system using a PriorityQueue where patients
 * with higher severity are treated first.
 * Example: Patients: [("John", 3), ("Alice", 5), ("Bob", 2)] -> Order: Alice, John, Bob.
 */
public class HospitalTriageSystem {

    public static void main(String[] args) {
        // Use a custom Comparator to sort by severity in DESCENDING order
        Comparator<Patient> triageComparator = Comparator.comparing(p -> p.severity, Comparator.reverseOrder());

        // PriorityQueue orders based on the Comparator
        Queue<Patient> triageQueue = new PriorityQueue<>(triageComparator);

        System.out.println("--- Admitting Patients ---");
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5)); // Highest priority
        triageQueue.add(new Patient("Bob", 2));
        triageQueue.add(new Patient("Kate", 5)); // Tied highest priority

        System.out.println("Current Queue Size: " + triageQueue.size());

        System.out.println("\n--- Treating Patients (Highest Severity First) ---");
        while (!triageQueue.isEmpty()) {
            Patient treated = triageQueue.poll();
            System.out.println("Treating: " + treated);
        }
    }
}
