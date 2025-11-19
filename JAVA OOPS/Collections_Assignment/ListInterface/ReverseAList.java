import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Reverses the elements of a given List without using built-in reverse methods.
 * Implement for both ArrayList and LinkedList.
 */
public class ReverseAList {

    public static <T> List<T> reverseList(List<T> originalList) {
        // Create a new list of the same type to store the reversed elements
        List<T> reversedList;
        if (originalList instanceof LinkedList) {
            reversedList = new LinkedList<>();
        } else {
            reversedList = new ArrayList<>();
        }

        // Iterate backwards through the original list and add elements to the new list
        for (int i = originalList.size() - 1; i >= 0; i--) {
            reversedList.add(originalList.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        // Test with ArrayList
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // Test with LinkedList
        List<String> linkedList = new LinkedList<>(List.of("A", "B", "C", "D"));
        List<String> reversedLinkedList = reverseList(linkedList);
        System.out.println("\nOriginal LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
