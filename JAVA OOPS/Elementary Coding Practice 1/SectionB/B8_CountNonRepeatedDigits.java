import java.util.Scanner;
import java.util.HashMap;

public class B8_CountNonRepeatedDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        
        long absNumber = Math.abs(number);
        HashMap<Integer, Integer> digitCounts = new HashMap<>();
        
        if (absNumber == 0) {
            System.out.println(1);
            return;
        }
        
        long temp = absNumber;
        while (temp > 0) {
            int digit = (int) (temp % 10);
            digitCounts.put(digit, digitCounts.getOrDefault(digit, 0) + 1);
            temp /= 10;
        }
        
        int nonRepeatedCount = 0;
        for (int count : digitCounts.values()) {
            if (count == 1) {
                nonRepeatedCount++;
            }
        }
        
        System.out.println(nonRepeatedCount);
    }
}
