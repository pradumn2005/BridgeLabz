import java.util.*;

class Factors {
    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    public static int product(int[] arr) {
        int p = 1;
        for (int x : arr) p *= x;
        return p;
    }

    public static int sumOfSquares(int[] arr) {
        int s = 0;
        for (int x : arr) s += (int)Math.pow(x, 2);
        return s;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] factors = findFactors(n);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Sum = " + sum(factors));
        System.out.println("Sum of Squares = " + sumOfSquares(factors));
        System.out.println("Product = " + product(factors));
    }
}
