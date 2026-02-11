import java.util.Scanner;
import java.util.InputMismatchException;

public class BmiCalculator {
    
    public static String[] calculateBmiAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status = "";
        
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        return new String[]{String.format("%.2f", bmi), status};
    }

    public static String[][] processAll(double[][] data) {
        String[][] results = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            results[i][0] = String.valueOf(data[i][1]);
            results[i][1] = String.valueOf(data[i][0]);
            
            String[] bmiData = calculateBmiAndStatus(data[i][0], data[i][1]);
            results[i][2] = bmiData[0];
            results[i][3] = bmiData[1];
        }
        return results;
    }

    public static void displayTable(String[][] results) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < results.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", results[i][0], results[i][1], results[i][2], results[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPersons = 10;
        double[][] personData = new double[numPersons][2];

        System.out.println("Enter weight(kg) and height(cm) for 10 persons:");
        for (int i = 0; i < numPersons; i++) {
            try {
                System.out.print("Person " + (i + 1) + " Weight: ");
                personData[i][0] = scanner.nextDouble();
                System.out.print("Person " + (i + 1) + " Height: ");
                personData[i][1] = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers.");
                scanner.nextLine();
                i--; 
            }
        }

        String[][] bmiResults = processAll(personData);
        displayTable(bmiResults);
        scanner.close();
    }
}
