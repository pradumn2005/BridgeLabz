class NumberChecker {
    static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    static int[] toDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }

    static boolean isDuck(int n) {
        int[] d = toDigits(n);
        for (int x : d) if (x == 0) return true;
        return false;
    }

    static boolean isArmstrong(int n) {
        int[] d = toDigits(n);
        int p = d.length, sum = 0;
        for (int x : d) sum += Math.pow(x, p);
        return sum == n;
    }

    static void largestTwo(int n) {
        int[] d = toDigits(n);
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int x : d) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2 && x != max1) max2 = x;
        }
        System.out.println("Largest: " + max1 + " Second Largest: " + max2);
    }

    static void smallestTwo(int n) {
        int[] d = toDigits(n);
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int x : d) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2 && x != min1) min2 = x;
        }
        System.out.println("Smallest: " + min1 + " Second Smallest: " + min2);
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println("Count: " + countDigits(n));
        System.out.println("Duck: " + isDuck(n));
        System.out.println("Armstrong: " + isArmstrong(n));
        largestTwo(n);
        smallestTwo(n);
    }
}
