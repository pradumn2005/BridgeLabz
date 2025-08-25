import java.util.Scanner;

public class SumNaturalFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Enter a natural number: ");
        number = input.nextInt();
        if (number > 0) {
            int sumFormula = number * (number + 1) / 2;
            int sumFor = 0;
            for (int i = 1; i <= number; i++) {
                sumFor += i;
            }
            System.out.println("Formula sum = " + sumFormula);
            System.out.println("For loop sum = " + sumFor);
        } else {
            System.out.println("Not a natural number");
        }
        input.close();
    }
}
