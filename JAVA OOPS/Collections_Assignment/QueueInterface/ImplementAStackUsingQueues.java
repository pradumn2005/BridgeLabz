import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements a Stack data structure (LIFO) using two Queues.
 * The push operation is made costly to ensure pop is always O(1) by keeping
 * the most recently pushed element at the front of q1.
 */
public class ImplementAStackUsingQueues {
    private Queue<Integer> q1; // Main queue, stores stack elements in LIFO order
    private Queue<Integer> q2; // Temporary queue

    public ImplementAStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push: O(N) - Costly
    public void push(int x) {
        // 1. Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // 2. Add the new element to q1 (it is now at the front)
        q1.add(x);

        // 3. Move all elements back from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop: O(1) - Removes and returns the element at the front (most recent)
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return q1.remove();
    }

    // Top: O(1) - Returns the element at the front (most recent)
    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementAStackUsingQueues stack = new ImplementAStackUsingQueues();

        System.out.println("Push 1, 2, 3");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop: " + stack.pop());         // Output: 3
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Pop: " + stack.pop());         // Output: 2
        System.out.println("Pop: " + stack.pop());         // Output: 1
        System.out.println("Is empty: " + stack.isEmpty()); // Output: true
    }
}
