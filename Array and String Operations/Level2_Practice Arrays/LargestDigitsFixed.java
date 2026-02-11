import java.util.Scanner;

public class LargestDigitsFixed {
    public static void main(String[] args) {
        // Declare scanner for user input
        Scanner input = new Scanner(System.in);
        
        // Prompt user for a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        // Validate user input
        if (number < 0) {
            System.out.println("Invalid Number. Exiting program.");
            System.exit(0);
        }
        
        // Declare fixed max size for digits array
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        
        // Declare index counter
        int index = 0;
        
        // Store number in a temporary variable
        int tempNumber = number;
        
        // Loop to extract digits
        while (tempNumber != 0) {
            // Check if array limit reached
            if (index == maxDigit) {
                break;
            }
            
            // Extract last digit and store in array
            digits[index] = tempNumber % 10;
            
            // Remove last digit from number
            tempNumber /= 10;
            
            // Increment index
            index++;
        }
        
        // Declare variables for largest and second largest
        int largest = -1;
        int secondLargest = -1;
        
        // Loop through the populated part of the array to find largest and second largest
        for (int i = 0; i < index; i++) {
            // Check if current digit is greater than largest
            if (digits[i] > largest) {
                // Update second largest
                secondLargest = largest;
                // Update largest
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                // Update second largest if condition met
                secondLargest = digits[i];
            }
        }
        
        // Display the results
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("No second largest digit found.");
        }
        
        // Close scanner
        input.close();
    }
}
