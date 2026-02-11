import java.util.Scanner;

class MatrixToArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get dimensions
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        // Create 2D Matrix
        int[][] matrix = new int[rows][cols];

        // Input Matrix elements
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Create 1D Array
        int[] flatArray = new int[rows * cols];
        int index = 0;

        // Copy 2D to 1D
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[index] = matrix[i][j];
                index++;
            }
        }

        // Display Result
        System.out.println("1D Array elements:");
        for (int i = 0; i < flatArray.length; i++) {
            System.out.print(flatArray[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
