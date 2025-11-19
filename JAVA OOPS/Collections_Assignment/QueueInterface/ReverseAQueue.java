import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reverses the elements of a queue using only queue operations and a temporary stack.
 * Input: [10, 20, 30] -> Output: [30, 20, 10].
 */
public class ReverseAQueue {

    public static <T> void reverseQueue(Queue<T> queue) {
        // Use a Stack as temporary storage
        Stack<T> stack = new Stack<>();

        // 1. Dequeue all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // 2. Pop all elements from the stack and enqueue them back into the queue
        // This puts them back in reverse order (LIFO from stack, then FIFO to queue)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue); // Output: [40, 30, 20, 10]
    }
}
