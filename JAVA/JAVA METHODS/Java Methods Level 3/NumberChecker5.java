class NumberChecker5 {
    static int sumDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) if (n % i == 0) sum += i;
        return sum;
    }

    static boolean isPerfect(int n) {
        return sumDivisors(n) == n;
    }

    static boolean isAbundant(int n) {
        return sumDivisors(n) > n;
    }

    static boolean isDeficient(int n) {
        return sumDivisors(n) < n;
    }

    static int fact(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    static boolean isStrong(int n) {
        int t = n, sum = 0;
        while (t > 0) {
            sum += fact(t % 10);
            t /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 145;
        System.out.println("Perfect: " + isPerfect(n));
        System.out.println("Abundant: " + isAbundant(n));
        System.out.println("Deficient: " + isDeficient(n));
        System.out.println("Strong: " + isStrong(n));
    }
}
