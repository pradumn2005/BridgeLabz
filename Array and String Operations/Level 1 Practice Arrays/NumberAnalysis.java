import java.util.Scanner;

class NumberAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define array of 5 elements
        int[] numbers = new int[5];

        // Get user input
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Analysis ---");
        // Loop through array to check Positive/Negative/Zero and Even/Odd
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (num > 0) {
                // Check for even or odd
                if (num % 2 == 0) {
                    System.out.println(num + " is Positive and Even.");
                } else {
                    System.out.println(num + " is Positive and Odd.");
                }
            } else if (num < 0) {
                System.out.println(num + " is Negative.");
            } else {
                System.out.println("Number is Zero.");
            }
        }

        // Compare first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        
        System.out.println("\n--- Comparison (First vs Last) ---");
        if (first == last) {
            System.out.println("First element (" + first + ") equals Last element (" + last + ").");
        } else if (first > last) {
            System.out.println("First element (" + first + ") is greater than Last element (" + last + ").");
        } else {
            System.out.println("First element (" + first + ") is less than Last element (" + last + ").");
        }

        input.close();
    }
}
