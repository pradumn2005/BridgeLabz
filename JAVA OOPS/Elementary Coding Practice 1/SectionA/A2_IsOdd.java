import java.util.Scanner;

public class A2_IsOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        if (number % 2 != 0) {
            System.out.println("The number is Odd.");
        } else {
            System.out.println("The number is Even.");
        }
    }
}
