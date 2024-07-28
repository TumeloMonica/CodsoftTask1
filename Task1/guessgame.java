import java.util.Random;
import java.util.Scanner;

public class guessgame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int minRange = 1;    // Minimum number in the range
        int maxRange = 100;  // Maximum number in the range
        int attemptsLimit = 5; // Limit of attempts per round
        int round = 1;
        int totalScore = 0;

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("\nRound " + round + " - Guess the number between " + minRange + " and " + maxRange + ".");
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " correctly.");
                    int score = attemptsLimit - attempts;
                    totalScore += score;
                    System.out.println("Score for this round: " + score);
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you did not guess the number. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }

            round++;
        }

        System.out.println("\nGame over. Your total score: " + totalScore);

        scanner.close();
    }

}