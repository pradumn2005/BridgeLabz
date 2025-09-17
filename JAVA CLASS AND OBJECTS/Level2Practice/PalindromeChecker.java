import java.util.*;
class PalindromeChecker {
    String text;
    PalindromeChecker(String t) {
        text = t;
    }
    boolean isPalindrome() {
        String rev = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(rev);
    }
    void display() {
        if (isPalindrome())
            System.out.println(text + " is a Palindrome");
        else
            System.out.println(text + " is not a Palindrome");
    }
    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker("madam");
        p.display();
    }
}
