import java.util.Scanner;

public class LowerCaseConverter {

    public static String convertToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
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
        
        String customLower = convertToLowerCase(text);
        String builtInLower = text.toLowerCase();
        
        System.out.println("Custom Lower: " + customLower);
        System.out.println("Built-in Lower: " + builtInLower);
        
        if (compareStrings(customLower, builtInLower)) {
            System.out.println("Result Match.");
        } else {
            System.out.println("Result Mismatch.");
        }
    }
}
