import java.util.Scanner;

public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Enter a natural number: ");
        number = input.nextInt();
        if (number > 0) {
            int sumFormula = number * (number + 1) / 2;
            int sumWhile = 0, i = 1;
            while (i <= number) {
                sumWhile += i;
                i++;
            }
            System.out.println("Formula sum = " + sumFormula);
            System.out.println("While loop sum = " + sumWhile);
        } else {
            System.out.println("Not a natural number");
        }
        input.close();
    }
}
