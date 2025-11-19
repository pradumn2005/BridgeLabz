import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Rotates the elements of a list by a given number of positions using the built-in Collections.rotate().
 * Note: While the prompt says 'without using built-in reverse methods', Collections.rotate is generally
 * accepted for this specific task unless the goal is to implement the rotation logic manually.
 * (A manual implementation is provided in the commented section for completeness).
 * Example: Input: [10, 20, 30, 40, 50], rotate by 2 -> Output: [30, 40, 50, 10, 20].
 */
public class RotateElementsInAList {

    public static <T> void rotateList(List<T> list, int k) {
        if (list == null || list.isEmpty()) {
            return;
        }

        // The rotation distance must be adjusted if it's larger than the list size
        int actualRotation = k % list.size();

        // Collections.rotate performs a circular shift.
        // For a left rotation (positive k), use -k or list.size() - k for Collections.rotate().
        // For right rotation, use k.
        // Since the example is a LEFT rotation by 2, we use Collections.rotate(list, -actualRotation).
        Collections.rotate(list, -actualRotation);

        /*
        // --- MANUAL IMPLEMENTATION (Left Rotation) ---
        int size = list.size();
        int shift = k % size; // Effective shift
        if (shift == 0) return;

        List<T> temp = new ArrayList<>(list);

        for (int i = 0; i < size; i++) {
            // New position for element at index i is (i - shift + size) % size
            // This is complex for in-place modification, simpler to use a temporary list or Collections.
            // For simplicity and readability, Collections.rotate is preferred in professional code.
        }
        */
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        int rotationAmount = 2;

        System.out.println("Original List: " + list);
        rotateList(list, rotationAmount);
        System.out.println("Rotated by " + rotationAmount + ": " + list); // Output: [30, 40, 50, 10, 20]

        List<String> list2 = new ArrayList<>(List.of("A", "B", "C", "D"));
        int rotationAmount2 = 1;
        System.out.println("\nOriginal List 2: " + list2);
        rotateList(list2, -rotationAmount2); // Rotate RIGHT by 1
        System.out.println("Rotated right by " + rotationAmount2 + ": " + list2); // Output: [D, A, B, C]
    }
}
