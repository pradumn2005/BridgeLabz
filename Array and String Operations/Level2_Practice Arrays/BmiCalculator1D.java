import java.util.Scanner;

public class BmiCalculator1D {
    public static void main(String[] args) {
        // Declare scanner for user input
        Scanner input = new Scanner(System.in);
        
        // Prompt for number of persons
        System.out.print("Enter number of persons: ");
        int numPersons = input.nextInt();
        
        // Validate user input
        if (numPersons <= 0) {
            System.out.println("Invalid number of persons. Exiting program.");
            System.exit(0);
        }
        
        // Create arrays for weight, height, BMI, and status
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        
        // Loop to take input and calculate BMI for each person
        for (int i = 0; i < weights.length; i++) {
            // Loop for validation
            while (true) {
                // Prompt for weight
                System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
                double w = input.nextDouble();
                
                // Prompt for height
                System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
                double h = input.nextDouble();
                
                // Validate inputs
                if (w > 0 && h > 0) {
                    weights[i] = w;
                    heights[i] = h;
                    break;
                } else {
                    System.out.println("Invalid input. Weight and height must be positive.");
                }
            }
            
            // Calculate BMI
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            // Determine weight status based on standard BMI table
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        // Display the results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < weights.length; i++) {
            System.out.println("Person " + (i + 1) + " | Height: " + heights[i] + "m | Weight: " + weights[i] + "kg | BMI: " + bmis[i] + " | Status: " + statuses[i]);
        }
        
        // Close scanner
        input.close();
    }
}
