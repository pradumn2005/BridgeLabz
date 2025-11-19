import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * Given a Map<String, Integer>, finds the key with the maximum value.
 * Example: Input: {A=10, B=20, C=15} -> Output: B.
 */
public class FindKeyWithHighestValue {

    public static String findMaxKey(Map<String, Integer> map) {
        // Handle empty map case
        if (map == null || map.isEmpty()) {
            return null;
        }

        // Use the Stream API to find the entry with the maximum value
        return map.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey) // Get the key from the entry
            .orElse(null); // Should not happen if map is not empty
    }

    public static void main(String[] args) {
        Map<String, Integer> data = Map.of("A", 10, "B", 20, "C", 15, "D", 20);
        String maxKey = findMaxKey(data);
        System.out.println("Map: " + data);
        System.out.println("Key with Highest Value: " + maxKey); // Prints 'B' or 'D' depending on stream ordering
    }
}
