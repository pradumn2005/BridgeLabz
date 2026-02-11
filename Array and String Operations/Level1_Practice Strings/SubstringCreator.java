import java.util.Scanner;

public class SubstringCreator {

    public static String createCustomSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
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
        String text = scanner.next();
        
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();
        
        String customSub = createCustomSubstring(text, start, end);
        String builtInSub = text.substring(start, end);
        
        System.out.println("Custom Substring: " + customSub);
        System.out.println("Built-in Substring: " + builtInSub);
        
        if (compareStrings(customSub, builtInSub)) {
            System.out.println("Results Match.");
        } else {
            System.out.println("Results Do Not Match.");
        }
    }
}
