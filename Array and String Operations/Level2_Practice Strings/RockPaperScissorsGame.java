import java.util.Scanner;

public class RockPaperScissorsGame {
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "rock";
        if (choice == 1) return "paper";
        return "scissors";
    }

    public static String findWinner(String userChoice, String compChoice) {
        if (userChoice.equals(compChoice)) {
            return "tie";
        }
        if ((userChoice.equals("rock") && compChoice.equals("scissors")) ||
            (userChoice.equals("paper") && compChoice.equals("rock")) ||
            (userChoice.equals("scissors") && compChoice.equals("paper"))) {
            return "user";
        }
        return "computer";
    }

    public static String[][] calculateStats(int userWins, int compWins, int ties, int totalGames) {
        String[][] stats = new String[3][2];
        double userPercentage = ((double) userWins / totalGames) * 100;
        double compPercentage = ((double) compWins / totalGames) * 100;
        double tiePercentage = ((double) ties / totalGames) * 100;

        stats[0][0] = "User Wins";
        stats[0][1] = String.format("%.2f%% (%d)", userPercentage, userWins);
        stats[1][0] = "Computer Wins";
        stats[1][1] = String.format("%.2f%% (%d)", compPercentage, compWins);
        stats[2][0] = "Ties";
        stats[2][1] = String.format("%.2f%% (%d)", tiePercentage, ties);

        return stats;
    }

    public static void displayStats(String[][] stats) {
        System.out.println("\n--- Game Statistics ---");
        System.out.println(String.format("%-15s | %-15s", "Entity", "Win Percentage"));
        System.out.println("----------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(String.format("%-15s | %-15s", stats[i][0], stats[i][1]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalGames = 0;
        
        System.out.print("Enter number of games to play: ");
        try {
            totalGames = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input.");
            System.exit(1);
        }

        int userWins = 0;
        int compWins = 0;
        int ties = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.print("Game " + (i + 1) + " - Enter rock, paper, or scissors: ");
            String userChoice = scanner.next().toLowerCase();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Skipping this round.");
                continue;
            }

            String compChoice = getComputerChoice();
            System.out.println("Computer chose: " + compChoice);

            String winner = findWinner(userChoice, compChoice);
            
            if (winner.equals("user")) {
                System.out.println("You win this round!");
                userWins++;
            } else if (winner.equals("computer")) {
                System.out.println("Computer wins this round!");
                compWins++;
            } else {
                System.out.println("It's a tie!");
                ties++;
            }
        }

        if (totalGames > 0) {
            String[][] stats = calculateStats(userWins, compWins, ties, totalGames);
            displayStats(stats);
        }
        
        scanner.close();
    }
}
