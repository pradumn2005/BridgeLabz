class Factors {
    static int[] factors(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) c++;
        int[] f = new int[c];
        int k = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) f[k++] = i;
        return f;
    }

    static int greatest(int[] arr) {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    static int product(int[] arr) {
        int p = 1;
        for (int x : arr) p *= x;
        return p;
    }

    static double productCubes(int[] arr) {
        double p = 1;
        for (int x : arr) p *= Math.pow(x, 3);
        return p;
    }

    public static void main(String[] args) {
        int n = 12;
        int[] f = factors(n);
        System.out.println("Factors: ");
        for (int x : f) System.out.print(x + " ");
        System.out.println("\nGreatest: " + greatest(f));
        System.out.println("Sum: " + sum(f));
        System.out.println("Product: " + product(f));
        System.out.println("Product of Cubes: " + productCubes(f));
    }
}
