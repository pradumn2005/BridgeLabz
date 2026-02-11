import java.util.Scanner;

public class CharFrequencyNestedLoops {

    public static String[] getFrequenciesNested(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        int uniqueCount = 0;

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && chars[i] != '0') {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
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

        String[] frequencies = getFrequenciesNested(text);
        System.out.println("Character Frequencies (Nested Loops):");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i]);
        }
        scanner.close();
    }
}
