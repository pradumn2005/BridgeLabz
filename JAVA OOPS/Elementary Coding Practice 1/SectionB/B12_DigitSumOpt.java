import java.util.Scanner;

public class B12_DigitSumOpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        String choice = scanner.next();
        
        long absNumber = Math.abs(number);
        long sum = 0;
        
        while (absNumber > 0) {
            long digit = absNumber % 10;
            
            if (choice.equalsIgnoreCase("even") && digit % 2 == 0) {
                sum += digit;
            } else if (choice.equalsIgnoreCase("odd") && digit % 2 != 0) {
                sum += digit;
            }
            
            absNumber /= 10;
        }
        
        System.out.println(sum);
    }
}
