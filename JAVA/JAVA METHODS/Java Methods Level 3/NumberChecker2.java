class NumberChecker2 {
    static int[] toDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }

    static int sumDigits(int n) {
        int[] d = toDigits(n);
        int s = 0;
        for (int x : d) s += x;
        return s;
    }

    static int sumSquares(int n) {
        int[] d = toDigits(n);
        int s = 0;
        for (int x : d) s += Math.pow(x, 2);
        return s;
    }

    static boolean isHarshad(int n) {
        return n % sumDigits(n) == 0;
    }

    static void frequency(int n) {
        int[] d = toDigits(n);
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int x : d) freq[x][1]++;
        for (int i = 0; i < 10; i++) if (freq[i][1] > 0)
            System.out.println(freq[i][0] + " -> " + freq[i][1]);
    }

    public static void main(String[] args) {
        int n = 21;
        System.out.println("Sum Digits: " + sumDigits(n));
        System.out.println("Sum Squares: " + sumSquares(n));
        System.out.println("Harshad: " + isHarshad(n));
        frequency(n);
    }
}
