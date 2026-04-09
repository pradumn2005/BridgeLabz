import java.util.Stack;

public class SortStackRecursion {
    public static void sortedInsert(Stack<Integer> stack, int key) {
        if (stack.isEmpty() || key > stack.peek()) {
            stack.push(key);
            return;
        }
        int temp = stack.pop();
        sortedInsert(stack, key);
        stack.push(temp);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
