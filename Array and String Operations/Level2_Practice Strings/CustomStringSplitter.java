import java.util.Scanner;

public class CustomStringSplitter {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitText(String text) {
        int length = findLength(text);
        int spaceCount = 0;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndices = new int[spaceCount];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndices[index] = i;
                index++;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;
        for (int i = 0; i < spaceCount; i++) {
            String word = "";
            for (int j = start; j < spaceIndices[i]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            start = spaceIndices[i] + 1;
        }

        String lastWord = "";
        for (int j = start; j < length; j++) {
            lastWord += text.charAt(j);
        }
        words[spaceCount] = lastWord;

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = "";
        
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error reading input.");
            System.exit(1);
        }

        String[] customWords = splitText(text);
        String[] builtInWords = text.split(" ");

        System.out.println("Custom Split Results:");
        for (int i = 0; i < customWords.length; i++) {
            System.out.println(customWords[i]);
        }

        boolean areEqual = compareArrays(customWords, builtInWords);
        System.out.println("Do the custom and built-in methods match? " + areEqual);
        
        scanner.close();
    }
}
