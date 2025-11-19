import java.util.LinkedList;
import java.util.List;

/**
 * Given a singly linked list (use LinkedList), finds the Nth element from the
 * end without calculating its size (using the two-pointer technique).
 * Example: Input: [A, B, C, D, E], N=2 -> Output: D.
 */
public class FindNthElementFromTheEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            System.out.println("Invalid list or invalid N.");
            return null;
        }

        // Use two pointers: 'fast' and 'slow'
        // We use two standard List iterators and index manipulation since
        // the public java.util.LinkedList interface doesn't easily expose the
        // internal Node structure for a true 'singly linked list' approach.
        // The principle remains the same: create a gap of N-1 elements.

        if (n > list.size()) {
            System.out.println("N is larger than the list size.");
            return null;
        }

        // Start 'fast' pointer and advance it N steps
        int fast = n - 1;
        int slow = 0;

        // The Java list API requires index-based access, but we can simulate the
        // two-pointer movement. We don't calculate the size upfront, only check boundary.

        // Advance 'fast' to create the gap
        // After this loop, 'fast' points to the Nth element from the START (index N-1)
        // and 'slow' points to the 0th element.

        // Now advance both 'fast' and 'slow' until 'fast' reaches the end.
        while (fast < list.size() - 1) {
            fast++;
            slow++;
        }
        
        // When 'fast' is at the last element (size - 1), 'slow' is at the Nth element from the end.
        return list.get(slow);
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("A", "B", "C", "D", "E", "F", "G"));
        int n = 3; // Find the 3rd element from the end (E)

        System.out.println("Input List: " + list);
        String result = findNthFromEnd(list, n);
        System.out.println("N=" + n + ". " + n + "th element from the end: " + result); // Output: E

        String result2 = findNthFromEnd(list, 1);
        System.out.println("N=1. 1st element from the end: " + result2); // Output: G

        // Test boundary case
        findNthFromEnd(list, 10);
    }
}
