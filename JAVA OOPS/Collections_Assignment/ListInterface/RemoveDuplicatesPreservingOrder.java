import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Removes duplicate elements from a list while maintaining the original order of elements.
 * Example: Input: [3, 1, 2, 2, 3, 4] -> Output: [3, 1, 2, 4].
 */
public class RemoveDuplicatesPreservingOrder {

    public static <T> List<T> removeDuplicates(List<T> list) {
        // 1. Use a LinkedHashSet. It only stores unique elements (Set property)
        // and maintains insertion order (Linked property).
        Set<T> uniqueSet = new LinkedHashSet<>(list);

        // 2. Clear the original list (or create a new one)
        // And populate it with the unique, ordered elements from the set.
        List<T> resultList = new ArrayList<>(uniqueSet);

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(3, 1, 2, 2, 3, 4, 1, 5, 4));
        System.out.println("Original List: " + input);

        List<Integer> uniqueList = removeDuplicates(input);
        System.out.println("Unique List (Order Preserved): " + uniqueList);
    }
}
