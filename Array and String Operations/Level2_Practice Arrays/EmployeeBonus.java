import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        // Declare scanner for user input
        Scanner input = new Scanner(System.in);
        
        // Declare fixed variables for array size and bonus percentages
        int numEmployees = 10;
        double highBonusRate = 0.05;
        double lowBonusRate = 0.02;
        int serviceThreshold = 5;
        
        // Declare arrays for storing employee data
        double[] oldSalary = new double[numEmployees];
        double[] yearsOfService = new double[numEmployees];
        double[] newSalary = new double[numEmployees];
        double[] bonusAmount = new double[numEmployees];
        
        // Declare variables for total calculations
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // Loop to take input for 10 employees
        for (int i = 0; i < oldSalary.length; i++) {
            // Prompt user for salary
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double currentSalary = input.nextDouble();
            
            // Prompt user for years of service
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double serviceYears = input.nextDouble();
            
            // Validate user input for salary and years of service
            if (currentSalary <= 0 || serviceYears < 0) {
                // Print error message
                System.out.println("Invalid input. Please enter positive values.");
                // Decrement index to ask for this employee again
                i--;
                continue;
            }
            
            // Store validated input in arrays
            oldSalary[i] = currentSalary;
            yearsOfService[i] = serviceYears;
            
            // Check if years of service is greater than the threshold
            if (yearsOfService[i] > serviceThreshold) {
                // Calculate bonus at higher rate
                bonusAmount[i] = oldSalary[i] * highBonusRate;
            } else {
                // Calculate bonus at lower rate
                bonusAmount[i] = oldSalary[i] * lowBonusRate;
            }
            
            // Compute new salary
            newSalary[i] = oldSalary[i] + bonusAmount[i];
            
            // Add to total accumulators
            totalBonus += bonusAmount[i];
            totalOldSalary += oldSalary[i];
            totalNewSalary += newSalary[i];
        }
        
        // Print the final calculated totals
        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        // Close the scanner
        input.close();
    }
}
