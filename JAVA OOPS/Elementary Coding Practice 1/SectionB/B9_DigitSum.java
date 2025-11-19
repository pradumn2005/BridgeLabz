import java.util.Scanner;

public class B9_DigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        
        long absNumber = Math.abs(number);
        long sum = 0;
        
        while (absNumber > 0) {
            sum += absNumber % 10;
            absNumber /= 10;
        }
        
        System.out.println(sum);
    }
}
