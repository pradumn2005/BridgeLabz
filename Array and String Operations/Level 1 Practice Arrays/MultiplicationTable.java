import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get number input
        System.out.print("Enter a number to generate its table: ");
        int number = input.nextInt();

        // Define array to store results (1 to 10)
        int[] tableResults = new int[10];

        // Calculate and store results
        for (int i = 0; i < tableResults.length; i++) {
            int multiplier = i + 1;
            tableResults[i] = number * multiplier;
        }

        // Display results
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 0; i < tableResults.length; i++) {
            int multiplier = i + 1;
            System.out.println(number + " * " + multiplier + " = " + tableResults[i]);
        }

        input.close();
    }
}
