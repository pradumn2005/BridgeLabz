import java.util.Scanner;

class DynamicInputSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Create storage for maximum 10 elements
        double[] numbers = new double[10];
        int index = 0;
        int maxLimit = 10;

        System.out.println("Enter numbers (Enter 0 or negative to stop, Max 10 numbers):");

        // Infinite loop to accept input
        while (true) {
            // Check if array is full
            if (index == maxLimit) {
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }

            System.out.print("Enter number " + (index + 1) + ": ");
            double entry = input.nextDouble();

            // Validation: Break if 0 or negative
            if (entry <= 0) {
                break;
            }

            // Store value and increment index
            numbers[index] = entry;
            index++;
        }

        // Calculate Total
        double total = 0.0;
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        // Display Total
        System.out.println("\nTotal Sum: " + total);

        input.close();
    }
}
