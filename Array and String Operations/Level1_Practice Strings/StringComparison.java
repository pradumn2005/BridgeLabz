import java.util.Scanner;

public class StringComparison {
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String text1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String text2 = scanner.next();
        
        boolean isSameCharAt = compareStrings(text1, text2);
        boolean isSameBuiltIn = text1.equals(text2);
        
        System.out.println("Custom Comparison Result: " + isSameCharAt);
        System.out.println("Built-in Comparison Result: " + isSameBuiltIn);
        
        if (isSameCharAt == isSameBuiltIn) {
            System.out.println("Validation Successful: Results match.");
        } else {
            System.out.println("Validation Failed.");
        }
    }
}
