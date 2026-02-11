import java.util.Scanner;

class RangeMultiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Take input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Define array size for multipliers 6, 7, 8, 9 (Size 4)
        int[] multiplicationResult = new int[4];
        
        // Loop from 6 to 9
        // Note: Array index 0 will hold result for 6, index 1 for 7, etc.
        for (int i = 6; i <= 9; i++) {
            int arrayIndex = i - 6; 
            multiplicationResult[arrayIndex] = number * i;
        }

        // Display results
        System.out.println("\nMultiplication Results (x6 to x9):");
        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = i + 6; // Reconstruct the multiplier
            System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
        }

        input.close();
    }
}
