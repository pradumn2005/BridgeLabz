import java.util.Scanner;

public class LargestDigitsDynamic {
    public static void main(String[] args) {
        // Declare scanner for user input
        Scanner input = new Scanner(System.in);
        
        // Prompt user for a number
        System.out.print("Enter a number: ");
        long number = input.nextLong();
        
        // Validate user input
        if (number < 0) {
            System.out.println("Invalid Number. Exiting program.");
            System.exit(0);
        }
        
        // Declare variables for dynamic array sizing
        int maxDigit = 10;
        int resizeAmount = 10;
        int[] digits = new int[maxDigit];
        
        // Declare index counter
        int index = 0;
        long tempNumber = number;
        
        // Loop to extract digits
        while (tempNumber != 0) {
            // Check if index reached current array capacity
            if (index == maxDigit) {
                // Increase capacity
                maxDigit += resizeAmount;
                // Create temporary array
                int[] tempArray = new int[maxDigit];
                
                // Copy elements to temporary array
                for (int i = 0; i < digits.length; i++) {
                    tempArray[i] = digits[i];
                }
                
                // Assign new array to digits reference
                digits = tempArray;
            }
            
            // Extract last digit and store
            digits[index] = (int)(tempNumber % 10);
            
            // Remove last digit
            tempNumber /= 10;
            
            // Increment index
            index++;
        }
        
        // Declare variables for largest and second largest
        int largest = -1;
        int secondLargest = -1;
        
        // Loop through the array to find max values
        for (int i = 0; i < index; i++) {
            // Check if current digit is greater than largest
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                // Check if current is greater than second largest
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
