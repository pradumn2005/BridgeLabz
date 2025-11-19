import java.util.Scanner;

public class A3_ReturnLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        int lastDigit = Math.abs(number) % 10;
        System.out.println(lastDigit);
    }
}
