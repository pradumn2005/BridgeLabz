import java.util.Scanner;

class StudentVoting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define array size
        int studentCount = 10;
        int[] ages = new int[studentCount];
        int votingAge = 18;

        // Loop to get user input for ages
        System.out.println("Enter the ages of " + studentCount + " students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            if (input.hasNextInt()) {
                ages[i] = input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                System.exit(0);
            }
        }

        // Loop to check voting eligibility
        System.out.println("\n--- Voting Eligibility Results ---");
        for (int i = 0; i < ages.length; i++) {
            int currentAge = ages[i];
            
            // Check logic
            if (currentAge < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age entered.");
            } else if (currentAge >= votingAge) {
                System.out.println("The student with the age " + currentAge + " can vote.");
            } else {
                System.out.println("The student with the age " + currentAge + " cannot vote.");
            }
        }

        input.close();
    }
}
