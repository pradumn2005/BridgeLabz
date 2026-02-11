import java.util.Scanner;

public class CharFrequencyArray {

    public static String[][] getFrequencies(String text) {
        int[] freq = new int[256];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            try {
                if (freq[text.charAt(i)] == 0) {
                    uniqueCount++;
                }
                freq[text.charAt(i)]++;
            } catch (ArrayIndexOutOfBoundsException e) {
                 System.out.println("Character outside ASCII range detected.");
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
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
        System.out.println("Character Frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + " : " + frequencies[i][1]);
        }
        scanner.close();
    }
}
