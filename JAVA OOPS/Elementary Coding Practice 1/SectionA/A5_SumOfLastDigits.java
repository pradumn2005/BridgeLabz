import java.util.Scanner;

public class A5_SumOfLastDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int sumOfLastDigits = Math.abs(a) % 10 + Math.abs(b) % 10;
        System.out.println(sumOfLastDigits);
    }
}
