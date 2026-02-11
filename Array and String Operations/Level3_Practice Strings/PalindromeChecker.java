import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeLoop(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text) {
        char[] rev = new char[text.length()];
        int j = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            rev[j] = text.charAt(i);
            j++;
        }
        return rev;
    }

    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        String text = "";
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Input error.");
            System.exit(1);
        }

        boolean loopResult = isPalindromeLoop(text);
        boolean recResult = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean arrResult = isPalindromeArray(text);

        System.out.println("Result using Loop logic: " + loopResult);
        System.out.println("Result using Recursive logic: " + recResult);
        System.out.println("Result using Array logic: " + arrResult);

        scanner.close();
    }
}
