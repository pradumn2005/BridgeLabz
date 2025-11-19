import java.util.Set;
import java.util.HashSet;

/**
 * Compares two sets and determines if they contain the same elements, regardless of order.
 * Set1: {1, 2, 3}, Set2: {3, 2, 1} -> Output: true.
 */
public class CheckIfTwoSetsAreEqual {

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        // The Set interface's contract for the equals() method states that two sets
        // are equal if and only if they contain the exact same elements.
        // It automatically handles size and element comparison, ignoring order.
        if (set1 == null || set2 == null) {
             return set1 == set2; // Only true if both are null
        }
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> set4 = new HashSet<>(Set.of(1, 2));

        System.out.println("Set 1: " + set1 + ", Set 2: " + set2 + " -> Equal? " + areSetsEqual(set1, set2));
        System.out.println("Set 1: " + set1 + ", Set 3: " + set3 + " -> Equal? " + areSetsEqual(set1, set3));
        System.out.println("Set 1: " + set1 + ", Set 4: " + set4 + " -> Equal? " + areSetsEqual(set1, set4));
    }
}
