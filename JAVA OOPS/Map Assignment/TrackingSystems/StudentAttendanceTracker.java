import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Tracks student attendance using Map<String, Integer> for name -> days present.
 */
public class StudentAttendanceTracker {

    public static void main(String[] args) {
        // Simulation parameters
        List<String> allStudents = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        int totalDays = 15;
        int attendanceThreshold = 10;

        // 1. Initialize the map with all students and zero days.
        Map<String, Integer> attendanceMap = new HashMap<>();
        for (String student : allStudents) {
            attendanceMap.put(student, 0);
        }
        System.out.println("--- Initial Attendance (Day 0) ---");
        System.out.println(attendanceMap);

        // 2. For each day, mark attendance (simulate attendance lists)
        List<List<String>> dailyAttendance = List.of(
            // Day 1
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            // Day 2
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            // Day 3
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            // Days 4-10 (7 days)
            List.of("Alice", "Charlie", "Eve"),
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            List.of("Alice", "Charlie", "David"),
            List.of("Alice", "Bob", "Eve"),
            List.of("Alice", "Charlie", "David", "Eve"),
            List.of("Alice", "Bob", "Charlie"),
            List.of("Alice", "Eve"),
            // Days 11-15 (5 days)
            List.of("Alice", "Bob", "Charlie", "David", "Eve"), // All present for the rest
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            List.of("Alice", "Bob", "Charlie", "David", "Eve"),
            List.of("Alice", "Bob", "Charlie", "David", "Eve")
        );


        System.out.println("\n--- Marking Attendance for " + totalDays + " Days ---");
        int day = 1;
        for (List<String> presentStudents : dailyAttendance) {
            for (String student : presentStudents) {
                // Increment count for present students. Should be present in the map.
                attendanceMap.computeIfPresent(student, (name, count) -> count + 1);
            }
            // For a complete simulation, you'd iterate through all 15 days,
            // but the above list simulates different attendance patterns.
        }

        System.out.println("\n--- Final Attendance Tally ---");
        attendanceMap.forEach((name, count) ->
            System.out.println(name + " was present for " + count + " days.")
        );


        // 3. Print the names of students who were present fewer than the threshold.
        System.out.println("\n--- Under-Attending Students ( < " + attendanceThreshold + " Days) ---");
        List<String> underAttending = attendanceMap.entrySet().stream()
            .filter(entry -> entry.getValue() < attendanceThreshold)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        if (underAttending.isEmpty()) {
            System.out.println("All students met the attendance threshold.");
        } else {
            System.out.println("Students needing attention: " + underAttending);
        }
    }
}
