import java.util.Scanner;

class MeanHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define array for 11 players
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the height of 11 football players:");

        // Input loop
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = input.nextDouble();
            
            // Add to sum immediately
            sum += heights[i];
        }

        // Calculate mean
        double mean = sum / heights.length;

        // Display Result
        System.out.println("\nTotal Sum of heights: " + sum);
        System.out.println("Mean Height of the team: " + mean);

        input.close();
    }
}
