import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7;
    private static final int MAX_NUMBER = 100;
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int score = 0;
            
            System.out.println("🎯 Welcome to Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER);
            
            boolean playAgain = true;
            
            while (playAgain) {
                int targetNumber = random.nextInt(MAX_NUMBER) + 1;
                int attempts = 0;
                boolean guessed = false;
                
                System.out.println("\n=== New Round ===");
                System.out.println("You have " + MAX_ATTEMPTS + " attempts!");
                
                while (attempts < MAX_ATTEMPTS && !guessed) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;
                    
                    if (guess == targetNumber) {
                        System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts!");
                        score += (MAX_ATTEMPTS - attempts + 1) * 10;
                        guessed = true;
                    } else if (guess < targetNumber) {
                        System.out.println("📈 Too low! " + (MAX_ATTEMPTS - attempts) + " attempts left.");
                    } else {
                        System.out.println("📉 Too high! " + (MAX_ATTEMPTS - attempts) + " attempts left.");
                    }
                }
                
                if (!guessed) {
                    System.out.println("😞 Game Over! The number was: " + targetNumber);
                }
                
                System.out.println("🏆 Current Score: " + score);
                System.out.print("Play again? (yes/no): ");
                String response = scanner.next();
                playAgain = response.equalsIgnoreCase("yes");
            }
            
            System.out.println("Thanks for playing! Final Score: " + score);
        }
    }
}