import java.util.Scanner;

public class B11_DigitSumOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        
        long absNumber = Math.abs(number);
        long sum = 0;
        
        while (absNumber > 0) {
            long digit = absNumber % 10;
            if (digit % 2 != 0) {
                sum += digit;
            }
            absNumber /= 10;
        }
        
        System.out.println(sum);
    }
}
