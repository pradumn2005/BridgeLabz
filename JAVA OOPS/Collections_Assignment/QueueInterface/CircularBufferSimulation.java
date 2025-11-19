import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements a Circular Buffer (fixed-size queue) using an array-based queue (LinkedList is used
 * in Java's Collections as it implements the Queue interface).
 * When full, overwrite the oldest element.
 * Example: Buffer size=3: Insert 1, 2, 3 -> Insert 4 -> Buffer: [2, 3, 4].
 */
public class CircularBufferSimulation {

    private final Queue<Integer> buffer;
    private final int capacity;

    public CircularBufferSimulation(int size) {
        this.capacity = size;
        this.buffer = new LinkedList<>();
    }

    // Insert operation that handles overflow
    public void insert(int element) {
        // If buffer is full, remove the oldest element (at the head of the queue)
        if (buffer.size() == capacity) {
            int oldest = buffer.remove(); // Remove oldest element (FIFO)
            System.out.println("Buffer full. Overwriting oldest element: " + oldest);
        }

        // Add the new element
        buffer.add(element);
        System.out.println("Inserted " + element + ". Current Buffer: " + buffer);
    }

    public void display() {
        System.out.println("Final Buffer Content: " + buffer);
    }

    public static void main(String[] args) {
        int bufferSize = 3;
        CircularBufferSimulation buffer = new CircularBufferSimulation(bufferSize);

        System.out.println("Buffer Size: " + bufferSize + "\n");

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3); // Buffer is now full: [1, 2, 3]

        System.out.println("\nBuffer is full, inserting 4 will overwrite 1.");
        buffer.insert(4); // Overwrites 1. Buffer: [2, 3, 4]

        System.out.println("\nBuffer is full, inserting 5 will overwrite 2.");
        buffer.insert(5); // Overwrites 2. Buffer: [3, 4, 5]

        buffer.display();
    }
}
