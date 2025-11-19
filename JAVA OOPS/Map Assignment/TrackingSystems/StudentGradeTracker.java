import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Demonstrates operations (add, update, remove, sorted iteration) on a Map
 * for tracking student grades (Map<String, Double>).
 */
public class StudentGradeTracker {

    public static void main(String[] args) {
        // 1. Adds several students and their grades (using HashMap for general purpose)
        Map<String, Double> gradeTracker = new HashMap<>();

        System.out.println("--- Initial Additions ---");
        gradeTracker.put("Alice", 85.5);
        gradeTracker.put("Bob", 92.0);
        gradeTracker.put("Charlie", 78.5);
        System.out.println("Current Grades: " + gradeTracker);

        // 2. Updates the grade for a student
        System.out.println("\n--- Update Operation ---");
        String studentToUpdate = "Bob";
        double newGrade = 95.5;
        gradeTracker.put(studentToUpdate, newGrade); // Map.put() updates if key exists
        System.out.println(studentToUpdate + "'s new grade: " + gradeTracker.get(studentToUpdate));
        System.out.println("Current Grades: " + gradeTracker);

        // 3. Removes a student who has dropped out
        System.out.println("\n--- Remove Operation ---");
        String studentToRemove = "Charlie";
        gradeTracker.remove(studentToRemove);
        System.out.println(studentToRemove + " removed. Size: " + gradeTracker.size());
        System.out.println("Current Grades: " + gradeTracker);

        // 4. Prints out the list of students and grades in alphabetical order of names.
        // TreeMap automatically sorts by key (String)
        Map<String, Double> sortedGrades = new TreeMap<>(gradeTracker);
        System.out.println("\n--- Students and Grades (Sorted) ---");
        sortedGrades.forEach((name, grade) ->
            System.out.println("Student: " + name + ", Grade: " + grade)
        );
    }
}
