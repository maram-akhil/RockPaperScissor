import java.util.Random;
import java.util.Scanner;

/**
 * Plays a game of Rock-Paper-Scissor.
 */
public class RockPaperScissor2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock-Paper-Scissor!");
        System.out.println("Enter your choice (rock/paper/scissor) or 'quit' to exit:");

        while (true) {
            String userChoice = scanner.nextLine().trim().toLowerCase();

            if (userChoice.equals("quit")) {
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            String computerChoice = getComputerChoice(random);
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }

        scanner.close();
    }

    /**
     * Checks if the user's choice is valid.
     *
     * @param choice the user's choice
     * @return true if the choice is valid, false otherwise
     */
    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissor");
    }

    /**
     * Generates the computer's choice randomly.
     *
     * @param random the random number generator
     * @return the computer's choice
     */
    private static String getComputerChoice(Random random) {
        String[] choices = {"rock", "paper", "scissor"};
        return choices[random.nextInt(choices.length)];
    }

    /**
     * Determines the winner of the game.
     *
     * @param userChoice    the user's choice
     * @param computerChoice the computer's choice
     * @return the result of the game
     */
    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        }

        switch (userChoice) {
            case "rock":
                return computerChoice.equals("scissor") ? "Rock crushes scissor! You win!" : "Paper covers rock! You lose!";
            case "paper":
                return computerChoice.equals("rock") ? "Paper covers rock! You win!" : "Scissor cuts paper! You lose!";
            case "scissor":
                return computerChoice.equals("paper") ? "Scissor cuts paper! You win!" : "Rock crushes scissor! You lose!";
            default:
                return "Invalid choice";
        }
    }
}