import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tracks website page visits using Map<String, Integer> for page URL -> visit count.
 */
public class WebsiteVisitTracker {

    private Map<String, Integer> visitCounts = new HashMap<>();

    // 1. When a page is visited, update the count
    public void recordVisit(String pageUrl) {
        visitCounts.merge(pageUrl, 1, Integer::sum);
        System.out.println("Visited: " + pageUrl + " | Total: " + visitCounts.get(pageUrl));
    }

    public void runSimulation(String[] pages) {
        System.out.println("--- Simulating User Session ---");
        for (String page : pages) {
            recordVisit(page);
        }
    }

    // 2. Print list of pages sorted by descending visit count
    public void printSortedReport() {
        System.out.println("\n--- Visit Report (Sorted by Count Descending) ---");

        // Sort the entries by value in descending order
        List<Map.Entry<String, Integer>> sortedEntries = visitCounts.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());

        sortedEntries.forEach(entry ->
            System.out.println(entry.getKey() + ": " + entry.getValue() + " visits")
        );
    }

    // 3. Print the page with the most visits
    public void printMostVisited() {
        if (visitCounts.isEmpty()) {
            System.out.println("No visits recorded.");
            return;
        }

        // Find the entry with the maximum value
        Map.Entry<String, Integer> mostVisited = visitCounts.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null);

        System.out.println("\n--- Most Visited Page ---");
        System.out.println(mostVisited.getKey() + " with " + mostVisited.getValue() + " visits.");
    }

    public static void main(String[] args) {
        WebsiteVisitTracker tracker = new WebsiteVisitTracker();
        String[] visits = {
            "home", "about", "products", "home",
            "products", "contact", "home", "products",
            "faq", "home"
        };

        tracker.runSimulation(visits);

        // Produce the report
        tracker.printSortedReport();
        tracker.printMostVisited();
    }
}
