import java.util.Set;
import java.util.HashSet;

/**
 * Finds the symmetric difference (elements present in either set but not in both) of two sets.
 * Set1: {1, 2, 3}, Set2: {3, 4, 5} -> Output: {1, 2, 4, 5}.
 */
public class SymmetricDifference {

    public static <T> Set<T> computeSymmetricDifference(Set<T> set1, Set<T> set2) {
        // Step 1: Compute the Union (elements in set1 OR set2)
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);

        // Step 2: Compute the Intersection (elements in set1 AND set2)
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Step 3: Symmetric Difference = Union - Intersection
        Set<T> symmetricDifference = union;
        symmetricDifference.removeAll(intersection);

        return symmetricDifference;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3, 7);
        Set<Integer> set2 = Set.of(3, 4, 5, 7);

        Set<Integer> diff = computeSymmetricDifference(set1, set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Symmetric Difference: " + diff); // {1, 2, 4, 5}
    }
}
