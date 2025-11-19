import java.util.Set;
import java.util.HashSet;

/**
 * Checks if one set (Set1) is a subset of another set (Set2).
 * Set1: {2, 3}, Set2: {1, 2, 3, 4} -> Output: true.
 */
public class FindSubsets {

    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        // The containsAll() method returns true if set2 contains all elements of set1.
        // This is the definition of set1 being a subset of set2 (set1 ⊆ set2).
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        Set<Integer> setA = Set.of(2, 3);
        Set<Integer> setB = Set.of(1, 2, 3, 4);
        Set<Integer> setC = Set.of(5, 6);

        System.out.println("Set A: " + setA + ", Set B: " + setB);
        System.out.println("Is Set A a subset of Set B? " + isSubset(setA, setB)); // true

        System.out.println("\nSet C: " + setC + ", Set B: " + setB);
        System.out.println("Is Set C a subset of Set B? " + isSubset(setC, setB)); // false
    }
}
