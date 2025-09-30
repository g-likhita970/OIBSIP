import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Rules:");
        System.out.println("1. The system will generate a number between 1 and 100.");
        System.out.println("2. You have 7 attempts to guess the number in each round.");
        System.out.println("3. Points are awarded based on attempts left.");
        System.out.println("Let's start!\n");
        System.out.println(); // ✅ fixed (previously incomplete)

        while (playAgain) {
            int number = rand.nextInt(100) + 1; // random number between 1-100
            int attempts = 7; // limit attempts
            boolean guessedCorrectly = false;

            System.out.println("🔢 A number between 1 and 100 has been generated. Try to guess it!");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts--;

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    int roundScore = (attempts + 1) * 10; // more attempts left = higher score
                    totalScore += roundScore;
                    System.out.println("✅ You earned " + roundScore + " points this round.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < number) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }

                if (attempts > 0) {
                    System.out.println("Attempts left: " + attempts);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was: " + number);
            }

            System.out.println("⭐ Total Score: " + totalScore);

            // Ask if user wants another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("\n🎯 Game Over! Your final score is: " + totalScore);
        System.out.println("Thanks for playing!");
    }
}
