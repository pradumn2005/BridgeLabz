import java.util.Scanner;

public class ReverseNumberArray {
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
        
        // Count the digits in the number
        int count = 0;
        int tempForCount = number;
        // Loop to count digits
        while (tempForCount > 0) {
            count++;
            tempForCount /= 10;
        }
        
        // Check if number is 0
        if (number == 0) {
            count = 1;
        }
        
        // Create array to store digits
        int[] originalDigits = new int[count];
        int tempForExtract = number;
        
        // Loop to extract digits
        for (int i = 0; i < originalDigits.length; i++) {
            originalDigits[i] = tempForExtract % 10;
            tempForExtract /= 10;
        }
        
        // Create array to store reverse
        int[] reversedArray = new int[count];
        
        // Loop to reverse the array
        for (int i = 0; i < originalDigits.length; i++) {
            // Map original index to reverse index
            reversedArray[i] = originalDigits[originalDigits.length - 1 - i];
        }
        
        // Display the reversed array elements
        System.out.print("Reversed number array: ");
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.print(reversedArray[i] + " ");
        }
        System.out.println();
        
        // Close scanner
        input.close();
    }
}
