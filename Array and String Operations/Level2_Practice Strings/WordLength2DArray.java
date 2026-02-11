import java.util.Scanner;

public class WordLength2DArray {
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
            if (text.charAt(i) == ' ') spaceCount++;
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
            for (int j = start; j < spaceIndices[i]; j++) word += text.charAt(j);
            words[i] = word;
            start = spaceIndices[i] + 1;
        }
        String lastWord = "";
        for (int j = start; j < length; j++) lastWord += text.charAt(j);
        words[spaceCount] = lastWord;
        return words;
    }

    public static String[][] getWordsAndLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = "";
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error reading input.");
            System.exit(1);
        }

        String[] words = splitText(text);
        String[][] wordsAndLengths = getWordsAndLengths(words);

        System.out.println(String.format("%-15s | %-10s", "Word", "Length"));
        System.out.println("--------------------------------");
        for (int i = 0; i < wordsAndLengths.length; i++) {
            int lengthAsInt = Integer.parseInt(wordsAndLengths[i][1]);
            System.out.println(String.format("%-15s | %-10d", wordsAndLengths[i][0], lengthAsInt));
        }
        
        scanner.close();
    }
}
