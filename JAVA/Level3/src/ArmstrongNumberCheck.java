import java.util.Scanner;
public class ArmstrongNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0;
        int originalNumber = number;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += digit * digit * digit;
            originalNumber /= 10;
        }

        if (sum == number) System.out.println(number + " is an Armstrong number");
        else System.out.println(number + " is not an Armstrong number");
        sc.close();
    }
}
