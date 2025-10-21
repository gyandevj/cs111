import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int targetNumber = rand.nextInt(100) + 1;
        
        System.out.println("guess the random number between 1 and 100");
        boolean gameWon = false;
        int guessCount = 0;
        
        while (!gameWon) {
            System.out.print("Enter your guess: ");
            
            int userGuess = StdIn.readInt();
            guessCount++;
            
            if (userGuess == targetNumber) {
                System.out.println("ayy u got it!");
                System.out.println("attempts:  " + guessCount);
                gameWon = true;
            } else if (userGuess < targetNumber) {
                System.out.println("Higher");
            } else {
                System.out.println("Lower");
            }
        }
    }
}
