import java.util.Scanner;

public class CustomStringTrimmer {
    public static int[] getTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

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
        System.out.print("Enter text with leading/trailing spaces: ");
        String text = "";
        
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error reading input.");
            System.exit(1);
        }

        int[] trimIndices = getTrimIndices(text);
        
        String customTrimmed = "";
        if (trimIndices[0] <= trimIndices[1]) {
            customTrimmed = customSubstring(text, trimIndices[0], trimIndices[1]);
        }

        String builtInTrimmed = text.trim();

        System.out.println("Custom Trimmed: '" + customTrimmed + "'");
        System.out.println("Built-in Trimmed: '" + builtInTrimmed + "'");

        boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Do the strings match? " + areEqual);
        
        scanner.close();
    }
}
