import java.util.Scanner;

public class A8_CountOdd5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        
        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();
            if (number % 2 != 0) {
                count++;
            }
        }
        
        System.out.println("Count of odd numbers: " + count);
    }
}
