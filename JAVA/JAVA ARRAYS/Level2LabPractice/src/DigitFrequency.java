import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        long num = sc.nextLong();

        String str = Long.toString(Math.abs(num));
        int[] digits = new int[str.length()];
        int[] freq = new int[10];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
            freq[digits[i]]++;
        }

        System.out.println("Digit\tFrequency");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println(i + "\t" + freq[i]);
            }
        }

        sc.close();
    }
}
