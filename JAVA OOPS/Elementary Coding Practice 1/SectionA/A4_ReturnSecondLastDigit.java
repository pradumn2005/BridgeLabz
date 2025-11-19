import java.util.Scanner;

public class A4_ReturnSecondLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        int absNumber = Math.abs(number);
        int secondLastDigit = (absNumber / 10) % 10;
        System.out.println(secondLastDigit);
    }
}
