public class PowerFunction {
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            int half = power(x, n / 2);
            return half * half;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 4;
        System.out.println(base + " raised to power " + exponent + " is: " + power(base, exponent));
    }
}
