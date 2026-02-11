import java.util.Scanner;

public class StudentVotingEligibility {
    public static int[] generateAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        return ages;
    }

    public static String[][] checkEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                results[i][1] = "false";
            } else if (ages[i] >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }
        return results;
    }

    public static void displayTable(String[][] data) {
        System.out.println(String.format("%-10s | %-15s", "Age", "Can Vote"));
        System.out.println("------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%-10s | %-15s", data[i][0], data[i][1]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = 10;

        System.out.print("Generating random ages for " + studentCount + " students...\n");
        
        int[] ages = generateAges(studentCount);
        String[][] eligibilityData = checkEligibility(ages);
        
        displayTable(eligibilityData);
        
        scanner.close();
    }
}
