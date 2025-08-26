import java.util.Scanner;
public class RockPaperScissors {
    public static String getComputerChoice() {
        double r = Math.random();
        if (r < 0.33)
            return "rock";
        else if (r < 0.66)
            return "paper";
        else
            return "scissors";
    }
    public static String getWinner(String userChoice, String compChoice) {
        if (userChoice.equals(compChoice))
            return "Draw";
        if ((userChoice.equals("rock") && compChoice.equals("scissors")) ||
            (userChoice.equals("paper") && compChoice.equals("rock")) ||
            (userChoice.equals("scissors") && compChoice.equals("paper")))
            return "User";
        return "Computer";
    }
    public static String[][] calculateStats(String[] results, int totalGames) {
        int userWins = 0, compWins = 0, draws = 0;
        for (String result : results) {
            if (result.equals("User"))
                userWins++;
            else if (result.equals("Computer"))
                compWins++;
            else
                draws++;
        }
        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;
        String[][] stats = {
            {"Player Wins", String.valueOf(userWins), String.format("%.2f%%", userPercent)},
            {"Computer Wins", String.valueOf(compWins), String.format("%.2f%%", compPercent)},
            {"Draws", String.valueOf(draws), ""}
        };
        return stats;
    }
    public static void displayResults(String[] userChoices, String[] compChoices, String[] winners, String[][] stats, int totalGames) {
        System.out.println("Game\tUser Choice\tComputer Choice\tWinner");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < totalGames; i++) {
            System.out.println((i + 1) + "\t" + userChoices[i] + "\t\t" + compChoices[i] + "\t\t" + winners[i]);
        }
        System.out.println("\nStatistics:");
        System.out.println("Category\t\tWins\tPercentage");
        System.out.println("-------------------------------------------");
        for (String[] stat : stats) {
            System.out.println(stat[0] + "\t" + stat[1] + "\t" + stat[2]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int totalGames = scanner.nextInt();
        String[] userChoices = new String[totalGames];
        String[] compChoices = new String[totalGames];
        String[] winners = new String[totalGames];
        for (int i = 0; i < totalGames; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.next().toLowerCase();
            userChoices[i] = userChoice;
            String compChoice = getComputerChoice();
            compChoices[i] = compChoice;
            winners[i] = getWinner(userChoice, compChoice);
        }
        String[][] stats = calculateStats(winners, totalGames);
        displayResults(userChoices, compChoices, winners, stats, totalGames);
        scanner.close();
    }
}