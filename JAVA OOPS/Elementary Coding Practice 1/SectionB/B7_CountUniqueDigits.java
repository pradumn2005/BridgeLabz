import java.util.Scanner;
import java.util.HashSet;

public class B7_CountUniqueDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        
        if (number == 0) {
            System.out.println(1);
            return;
        }
        
        long absNumber = Math.abs(number);
        HashSet<Integer> uniqueDigits = new HashSet<>();
        
        while (absNumber > 0) {
            int digit = (int) (absNumber % 10);
            uniqueDigits.add(digit);
            absNumber /= 10;
        }
        
        System.out.println(uniqueDigits.size());
    }
}
