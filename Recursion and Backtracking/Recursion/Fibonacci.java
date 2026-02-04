public class Fibonacci {
    public static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = getFibonacci(n);
        System.out.println("Fibonacci number at index " + n + " is: " + result);
    }
}
