import java.util.Scanner;

public class TemperatureAnalysis {
    public static void main(String[] args) {
        double[] temperatures = {20, 25, 22, 24, 21};
        int n = temperatures.length;

        System.out.println("Running Algorithm A:");
        System.out.println("Result: " + algorithmA(temperatures, n));

        System.out.println("\nRunning Algorithm B:");
        System.out.println("Result: " + algorithmB(temperatures, n));
    }

    // Algorithm A: Correct approach
    public static double algorithmA(double[] temperature, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total = total + temperature[i];
        }
        double average = total / n;
        return average;
    }

    // Algorithm B: As described in problem statement (contains logical error)
    public static double algorithmB(double[] temperature, int n) {
        if (n == 0) return 0; 
        
        double sum = temperature[0];
        
        // Loop from 2nd element to nth element
        for (int i = 1; i < n; i++) {
            sum = sum + temperature[i];
        }
        
        // Buggy loop as described in text
        for (int i = 0; i < n; i++) {
            sum = sum / n;
        }
        
        return sum;
    }
}
