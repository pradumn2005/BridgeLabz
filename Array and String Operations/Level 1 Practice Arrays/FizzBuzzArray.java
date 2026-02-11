import java.util.Scanner;

class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input number
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            System.exit(0);
        }

        // Create String Array (size + 1 to handle 0 to number)
        String[] results = new String[number + 1];

        // Loop and Logic
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        // Display Results
        System.out.println("\nFizzBuzz Results:");
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        input.close();
    }
}
