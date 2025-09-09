import java.util.Arrays;

class NumberChecker3 {
    static int[] toDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }

    static int[] reverse(int[] arr) {
        int[] r = new int[arr.length];
        for (int i = 0; i < arr.length; i++) r[i] = arr[arr.length - 1 - i];
        return r;
    }

    static boolean compare(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    static boolean isPalindrome(int n) {
        int[] d = toDigits(n);
        return compare(d, reverse(d));
    }

    static boolean isDuck(int n) {
        int[] d = toDigits(n);
        for (int x : d) if (x == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println("Palindrome: " + isPalindrome(n));
        System.out.println("Duck: " + isDuck(n));
    }
}
