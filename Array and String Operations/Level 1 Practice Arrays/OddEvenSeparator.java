import java.util.Scanner;

class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get input
        System.out.print("Enter a Natural Number (Limit): ");
        int number = input.nextInt();

        // Validate Natural Number
        if (number <= 0) {
            System.err.println("Error: Not a natural number.");
            System.exit(0);
        }

        // Create arrays. Max possible size for either is roughly half + 1
        int size = (number / 2) + 1;
        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];

        // Indexes for the new arrays
        int evenIndex = 0;
        int oddIndex = 0;

        // Iterate from 1 to number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print Odd Array
        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print Even Array
        System.out.print("\nEven Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
