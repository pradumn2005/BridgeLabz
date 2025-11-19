import java.util.HashMap;
import java.util.Map;

/**
 * Merges two maps such that if a key exists in both, their values are summed.
 * Example: Map1: {A=1, B=2}, Map2: {B=3, C=4} -> Output: {A=1, B=5, C=4}.
 */
public class MergeTwoMaps {

    public static Map<String, Integer> mergeAndSum(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Start with a copy of the first map
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        // Iterate over the second map
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // Use the merge method: if key exists, sum the values; otherwise, put the new value
            mergedMap.merge(key, value, Integer::sum);
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4, "D", 5);
        Map<String, Integer> merged = mergeAndSum(map1, map2);
        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        System.out.println("Merged Map: " + merged);
    }
}
