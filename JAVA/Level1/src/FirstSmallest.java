import java.util.Scanner;

public class FirstSmallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1, number2, number3;
        System.out.print("Enter three numbers: ");
        number1 = input.nextInt();
        number2 = input.nextInt();
        number3 = input.nextInt();
        System.out.println("Is the first number the smallest? " + (number1 < number2 && number1 < number3));
        input.close();
    }
}
