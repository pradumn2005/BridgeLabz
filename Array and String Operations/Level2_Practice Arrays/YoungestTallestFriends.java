import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        // Declare scanner for user input
        Scanner input = new Scanner(System.in);
        
        // Declare fixed variables
        int numFriends = 3;
        String[] friendNames = {"Amar", "Akbar", "Anthony"};
        
        // Declare arrays for age and height
        int[] ages = new int[numFriends];
        double[] heights = new double[numFriends];
        
        // Loop to take user input for ages and heights
        for (int i = 0; i < friendNames.length; i++) {
            // Loop for validation
            while (true) {
                // Prompt for age
                System.out.print("Enter age for " + friendNames[i] + ": ");
                ages[i] = input.nextInt();
                
                // Prompt for height
                System.out.print("Enter height for " + friendNames[i] + " (in cm): ");
                heights[i] = input.nextDouble();
                
                // Validate input
                if (ages[i] > 0 && heights[i] > 0) {
                    // Valid input, break out of validation loop
                    break;
                } else {
                    // Invalid input, prompt again
                    System.out.println("Invalid input. Age and height must be positive.");
                }
            }
        }
        
        // Initialize variables to find youngest and tallest
        int minAge = ages[0];
        double maxHeight = heights[0];
        String youngestFriend = friendNames[0];
        String tallestFriend = friendNames[0];
        
        // Loop through the arrays to find youngest and tallest
        for (int i = 1; i < ages.length; i++) {
            // Check if current age is less than minimum age found so far
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestFriend = friendNames[i];
            }
            
            // Check if current height is greater than maximum height found so far
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestFriend = friendNames[i];
            }
        }
        
        // Display the result
        System.out.println("\nThe youngest friend is: " + youngestFriend + " (Age: " + minAge + ")");
        System.out.println("The tallest friend is: " + tallestFriend + " (Height: " + maxHeight + " cm)");
        
        // Close scanner
        input.close();
    }
}
