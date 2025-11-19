import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of strings, counts the frequency of each element and returns the results in a Map.
 * Input: ["apple", "banana", "apple", "orange"] -> Output: {apple=2, banana=1, orange=1}
 */
public class FindFrequencyOfElements {

    public static Map<String, Integer> countFrequencies(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String element : list) {
            // Use Map.merge for clean incrementing:
            // If the key exists, sum the current value with 1. If not, put 1.
            frequencyMap.merge(element, 1, Integer::sum);
        }

        return frequencyMap;

        // Alternative modern solution using streams:
        /*
        return list.stream()
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
        */
    }

    public static void main(String[] args) {
        List<String> input = List.of("apple", "banana", "apple", "orange", "grape", "banana", "apple");
        Map<String, Integer> result = countFrequencies(input);
        System.out.println("Input List: " + input);
        System.out.println("Frequencies: " + result);
    }
}
