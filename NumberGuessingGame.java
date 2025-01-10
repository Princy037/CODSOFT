import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0, roundsWon = 0;
        String playAgain;

        do {
            roundsPlayed++;
            int number = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 5;
            boolean won = false;
            int lastGuess = -1; // Variable to store the user's last guess

            System.out.println("\nRound " + roundsPlayed + ": Guess the number (between 1 and 100). You have " + attempts + " attempts.");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");
                lastGuess = scanner.nextInt();

                if (lastGuess == number) {
                    System.out.println("Congratulations! You guessed the correct number in " + i + " attempts.");
                    roundsWon++;
                    won = true;
                    break;
                } else if (lastGuess < number) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!won) {
                System.out.println("You've run out of attempts. The correct number was " + number + ".");
            } else {
                System.out.println("Your correct guess was: " + lastGuess);
            }

            System.out.println("Score: " + roundsWon + "/" + roundsPlayed);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().trim().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("\nThanks for playing! Final Score:");
        System.out.println("Rounds Played: " + roundsPlayed + ", Rounds Won: " + roundsWon);
        scanner.close();
    }
}
