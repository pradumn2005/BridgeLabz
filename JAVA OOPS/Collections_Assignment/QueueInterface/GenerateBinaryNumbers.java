import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Generates the first N binary numbers (as strings) using a queue.
 * N=5 -> Output: ["1", "10", "11", "100", "101"].
 */
public class GenerateBinaryNumbers {

    public static List<String> generate(int n) {
        List<String> result = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();

        if (n < 1) return result;

        // Start with the first binary number
        queue.add("1");

        for (int i = 0; i < n; i++) {
            // 1. Dequeue the next number (N)
            String current = queue.remove();
            
            // 2. Add it to the result list
            result.add(current);

            // 3. Enqueue N + "0"
            queue.add(current + "0");
            
            // 4. Enqueue N + "1"
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        List<String> binaryNumbers = generate(n);
        System.out.println("First " + n + " Binary Numbers: " + binaryNumbers);
    }
}
