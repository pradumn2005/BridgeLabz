import java.util.Scanner;

public class A9_CountEvenOrOdd5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int evenCount = 0;
        int oddCount = 0;
        
        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);
    }
}
