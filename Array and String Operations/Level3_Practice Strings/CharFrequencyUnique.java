import java.util.Scanner;

public class CharFrequencyUnique {

    public static char[] getUniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean exists = false;
            for (int j = 0; j < count; j++) {
                if (temp[j] == c) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                temp[count] = c;
                count++;
            }
        }
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static String[][] getFrequencies(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = getUniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = "";
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Input error.");
            System.exit(1);
        }

        String[][] frequencies = getFrequencies(text);
        System.out.println("Character Frequencies (Using Unique Array):");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("'" + frequencies[i][0] + "' : " + frequencies[i][1]);
        }
        scanner.close();
    }
}
