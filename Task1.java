import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Let's play a guessing game!");
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int guessedNumber = 0;

            while (guessedNumber != targetNumber) {
                attempts++;
                System.out.print("Guess a number between 1 and 100: ");
                guessedNumber = scanner.nextInt();

                if (guessedNumber == targetNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    score++;
                } else if (guessedNumber < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts >= 5) {
                    System.out.println("You have reached the maximum number of attempts.");
                    break;
                }
            }

            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Your final score is: " + score);
    }
}