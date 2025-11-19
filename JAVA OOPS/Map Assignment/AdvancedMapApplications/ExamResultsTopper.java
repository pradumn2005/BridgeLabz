import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tracks student scores per subject using Map<String, Map<String, Integer>>
 * for Subject -> (Student -> Marks).
 */
public class ExamResultsTopper {

    public static void main(String[] args) {
        // Map<Subject, Map<Student, Marks>>
        Map<String, Map<String, Integer>> results = new HashMap<>();

        // 1. Add multiple subjects and marks
        results.put("Math", Map.of("Alice", 95, "Bob", 88, "Charlie", 95));
        results.put("Physics", Map.of("Alice", 78, "Bob", 85, "Charlie", 92, "David", 98));
        results.put("History", Map.of("Alice", 65, "Bob", 72, "Charlie", 80));

        System.out.println("--- Exam Results ---");
        results.forEach((subject, scores) -> System.out.println(subject + ": " + scores));

        // 2. Find the top scorer per subject.
        findTopScorerPerSubject(results);

        // 3. Print the average score per subject.
        printAverageScorePerSubject(results);

        // 4. List subjects where at least one student scored above 95
        listHighScoringSubjects(results, 95);
    }

    public static void findTopScorerPerSubject(Map<String, Map<String, Integer>> results) {
        System.out.println("\n--- Top Scorer Per Subject ---");
        results.forEach((subject, scores) -> {
            Optional<Map.Entry<String, Integer>> topEntry = scores.entrySet().stream()
                .max(Map.Entry.comparingByValue());

            if (topEntry.isPresent()) {
                // Find all students who scored the max score (in case of ties)
                int maxScore = topEntry.get().getValue();
                List<String> topStudents = scores.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxScore)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

                System.out.println(subject + ": " + topStudents + " (Score: " + maxScore + ")");
            }
        });
    }

    public static void printAverageScorePerSubject(Map<String, Map<String, Integer>> results) {
        System.out.println("\n--- Average Score Per Subject ---");
        results.forEach((subject, scores) -> {
            if (scores.isEmpty()) return;

            double average = scores.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

            System.out.printf("%s: %.2f%n", subject, average);
        });
    }

    public static void listHighScoringSubjects(Map<String, Map<String, Integer>> results, int threshold) {
        System.out.println("\n--- Subjects with a Score Above " + threshold + " ---");
        List<String> highScoreSubjects = results.entrySet().stream()
            .filter(entry -> entry.getValue().values().stream().anyMatch(score -> score > threshold))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println("Subjects: " + highScoreSubjects);
    }
}
