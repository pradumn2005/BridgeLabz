import java.util.Scanner;

class FactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Take input
        System.out.print("Enter a number to find its factors: ");
        int number = input.nextInt();

        // Initialize dynamic array variables
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Loop to find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Check if array is full
                if (index == maxFactor) {
                    // Double the size
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    
                    // Copy elements
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    
                    // Reassign array
                    factors = temp;
                }

                // Add factor and increment index
                factors[index] = i;
                index++;
            }
        }

        // Display factors
        System.out.println("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
