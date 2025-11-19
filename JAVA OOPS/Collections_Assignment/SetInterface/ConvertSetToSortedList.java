import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Converts a HashSet of integers into a sorted list in ascending order.
 * Input: {5, 3, 9, 1} -> Output: [1, 3, 5, 9].
 */
public class ConvertSetToSortedList {

    public static List<Integer> convertAndSort(Set<Integer> set) {
        // 1. Convert the Set to an ArrayList (or LinkedList)
        List<Integer> sortedList = new java.util.ArrayList<>(set);

        // 2. Sort the list using Collections.sort()
        Collections.sort(sortedList);

        return sortedList;

        // Alternative modern solution using streams:
        /*
        return set.stream()
            .sorted()
            .collect(Collectors.toList());
        */
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1, 8, 2));

        List<Integer> sortedList = convertAndSort(inputSet);

        System.out.println("Original Set: " + inputSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
