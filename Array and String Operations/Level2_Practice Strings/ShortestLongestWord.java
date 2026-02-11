import java.util.Scanner;

public class ShortestLongestWord {
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

    public static int[] findShortestLongestIndices(String[][] wordsAndLengths) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLength = Integer.parseInt(wordsAndLengths[0][1]);
        int maxLength = Integer.parseInt(wordsAndLengths[0][1]);

        for (int i = 1; i < wordsAndLengths.length; i++) {
            int currentLength = Integer.parseInt(wordsAndLengths[i][1]);
            if (currentLength < minLength) {
                minLength = currentLength;
                minIndex = i;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
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
        int[] indices = findShortestLongestIndices(wordsAndLengths);

        System.out.println("Shortest string: " + wordsAndLengths[indices[0]][0] + " (Length: " + wordsAndLengths[indices[0]][1] + ")");
        System.out.println("Longest string: " + wordsAndLengths[indices[1]][0] + " (Length: " + wordsAndLengths[indices[1]][1] + ")");
        
        scanner.close();
    }
}
