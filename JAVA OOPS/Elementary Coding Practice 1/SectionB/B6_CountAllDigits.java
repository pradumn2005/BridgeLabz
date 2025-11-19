import java.util.Scanner;

public class B6_CountAllDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        
        if (number == 0) {
            System.out.println(1);
            return;
        }
        
        long absNumber = Math.abs(number);
        int count = 0;
        while (absNumber > 0) {
            absNumber /= 10;
            count++;
        }
        
        System.out.println(count);
    }
}
