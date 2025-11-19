import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Inverts a Map<K, V> to produce a Map<V, List<K>>.
 * Handles duplicate values by storing all corresponding keys in a list.
 * Example: Input: {A=1, B=2, C=1} -> Output: {1=[A, C], 2=[B]}
 */
public class InvertAMap {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // Use computeIfAbsent to ensure a List exists for the value (new key)
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = Map.of("A", 1, "B", 2, "C", 1, "D", 3, "E", 2);
        Map<Integer, List<String>> inverted = invertMap(original);
        System.out.println("Original Map: " + original);
        System.out.println("Inverted Map: " + inverted);
    }
}
