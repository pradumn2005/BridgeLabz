import java.util.Scanner;

public class UpperCaseConverter {

    public static String convertToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String customUpper = convertToUpperCase(text);
        String builtInUpper = text.toUpperCase();
        
        System.out.println("Custom Upper: " + customUpper);
        System.out.println("Built-in Upper: " + builtInUpper);
        
        if (compareStrings(customUpper, builtInUpper)) {
            System.out.println("Result Match.");
        } else {
            System.out.println("Result Mismatch.");
        }
    }
}
