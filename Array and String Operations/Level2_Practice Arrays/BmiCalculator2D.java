import java.util.Scanner;

public class BmiCalculator2D {
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
        
        // Create 2D array for weight, height, and BMI. Column 0: Weight, 1: Height, 2: BMI
        int cols = 3;
        double[][] personData = new double[numPersons][cols];
        
        // Create array for status
        String[] weightStatus = new String[numPersons];
        
        // Loop to take input and calculate BMI
        for (int i = 0; i < personData.length; i++) {
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
                    personData[i][0] = w;
                    personData[i][1] = h;
                    break;
                } else {
                    System.out.println("Invalid input. Weight and height must be positive. Please try again.");
                }
            }
            
            // Calculate BMI and store in 3rd column
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display the results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < personData.length; i++) {
            System.out.println("Person " + (i + 1) + " | Height: " + personData[i][1] + "m | Weight: " + personData[i][0] + "kg | BMI: " + personData[i][2] + " | Status: " + weightStatus[i]);
        }
        
        // Close scanner
        input.close();
    }
}
