import java.util.Set;
import java.util.HashSet;

/**
 * Given two sets, computes their union and intersection.
 * Set1: {1, 2, 3}, Set2: {3, 4, 5} -> Union: {1, 2, 3, 4, 5}, Intersection: {3}.
 */
public class UnionAndIntersection {

    public static <T> Set<T> computeUnion(Set<T> set1, Set<T> set2) {
        // Start with a copy of set1
        Set<T> union = new HashSet<>(set1);
        // Add all elements from set2 (duplicates are automatically ignored by Set)
        union.addAll(set2);
        return union;
    }

    public static <T> Set<T> computeIntersection(Set<T> set1, Set<T> set2) {
        // Start with a copy of set1
        Set<T> intersection = new HashSet<>(set1);
        // Retain only the elements that are also present in set2
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3, 6);
        Set<Integer> set2 = Set.of(3, 4, 5, 6);

        Set<Integer> union = computeUnion(set1, set2);
        Set<Integer> intersection = computeIntersection(set1, set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union (Set1 U Set2): " + union);         // {1, 2, 3, 4, 5, 6}
        System.out.println("Intersection (Set1 ∩ Set2): " + intersection); // {3, 6}
    }
}
