import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Simulates vote counting in an election using a Map<String, Integer>
 * for candidate -> vote count.
 */
public class VotingCount {

    public static void main(String[] args) {
        Map<String, Integer> voteCounts = new HashMap<>();

        // Simulate 3 candidates
        String[] candidates = {"Emily", "Jack", "Sarah"};

        // Simulate 10 votes
        String[] votes = {
            "Emily", "Jack", "Emily", "Sarah", "Emily",
            "Jack", "Sarah", "Emily", "Jack", "Sarah"
        };

        System.out.println("--- Simulating Votes ---");
        for (String candidate : votes) {
            // Check if the candidate is already in the map; if yes, increment; if not, add with count = 1.
            voteCounts.merge(candidate, 1, Integer::sum);
            System.out.println("Voted for: " + candidate + " | Current total: " + voteCounts.get(candidate));
        }

        System.out.println("\n--- Final Vote Results ---");
        // Print total votes each candidate got
        voteCounts.forEach((name, count) ->
            System.out.println(name + ": " + count + " votes")
        );

        // Find the candidate with the highest votes
        Map.Entry<String, Integer> winner = voteCounts.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null);

        System.out.println("\n--- Election Winner ---");
        if (winner != null) {
            System.out.println("The candidate with the highest votes is: " + winner.getKey() + " with " + winner.getValue() + " votes.");
        } else {
            System.out.println("No votes were recorded.");
        }
    }
}
