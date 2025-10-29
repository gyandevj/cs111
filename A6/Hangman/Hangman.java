import java.nio.file.Files;
import java.nio.file.Paths;
public class Hangman {
    public static char[] selectWord(String inputFile){
	StdIn.setFile(inputFile);
        int numWords = StdIn.readInt();
        String[] words = new String[numWords];
        for(int i = 0; i < numWords; i++) {
            words[i] = StdIn.readString();
        }
        int randomIndex = StdRandom.uniform(numWords);
        int wordLen = words[randomIndex].length();
        char[] word = new char[wordLen];
        for ( int i = 0; i < words[randomIndex].length(); i++ ) {
            word[i] = words[randomIndex].charAt(i);
        }
        return word;
    }
    public static boolean checkLetter(char[] userLetters, char[] word, char guess){
        boolean found = false;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                if (userLetters[i] == '_') {
                    userLetters[i] = guess;
                    found = true;
                } else {
                    found = true;
                }
            }
        }
        return found;
    }
    public static boolean markGuessed(boolean[] guessedLetters, char letter){
        int index = (int) letter - (int) 'a';
        if (index < 0 || index >= guessedLetters.length) {
            return false;
        }
        if (guessedLetters[index]) {
            return false;
        } else {
            guessedLetters[index] = true;
            return true;
        }
    }
    public static boolean checkWin(char[] userLetters){
        for (int i = 0; i < userLetters.length; i++) {
            if (userLetters[i] == '_') return false;
        }
        return true;
    }
    public static void exportStats(char[] userLetters, char[] word, int totalGuesses, int wrongGuesses, String outputFile){
        StdOut.setFile(outputFile);
        boolean won = checkWin(userLetters);
        if (won) {
            StdOut.println("(You won)");
        } else {
            StdOut.println("(You lost)");
        }
        int points = 0;
        if (won) {
            if (totalGuesses == 0) {
                points = 100;
            } else {
                double ratio = ((double) wrongGuesses) / ((double) totalGuesses);
                double rawScore = 100.0 - (ratio * 100.0);
                points = (int) rawScore;
            }
        } else {
            points = 0;
        }
        StdOut.println("Points: " + points);
        StdOut.print("The word was: ");
        for (char c : word) StdOut.print(c);
        StdOut.println();
        StdOut.println("Total guesses: " + totalGuesses);
        StdOut.println("Incorrect guesses: " + wrongGuesses);
    }
    public static void main(String[] args) {
        if(args.length != 2){
            StdOut.println("Incorrect number of command line arguments\nCorrect usage: java Hangman inputFileName outputFileName");
        }
        else{
            if(!Files.exists(Paths.get(args[0]))) {
                StdOut.println("The file " + args[0] + " was not found and might not exist, make sure you type the name of the file correcly");
            }
            else{
                String gameWord = new String(selectWord(args[0]));
                StdIn.resetFile();
                StdOut.println("The word contains " + gameWord.length() + " characters");
                boolean[] guessedLetters = new boolean[26];
                char[] userLetters = new char[gameWord.length()];
                for(int i = 0; i < userLetters.length; i++){
                    userLetters[i] = '_';
                }
                int totalGuesses = 0;
                int wrongGuesses = 0;
                boolean quit = false;
                while(wrongGuesses < 6){
                    StdOut.print("Enter a letter guess, or 0 to quit: ");
                    char inputChar = StdIn.readLine().charAt(0);
                    if(inputChar == '0'){
                        quit = true;
                        break;
                    }
                    int validChar = validateChar(inputChar);
                    if(validChar == -1){
                        StdOut.println("The character " + inputChar + " is not a valid letter, please enter in a letter");
                    }
                    else{
                        char guess = (char) validChar;
                        if(markGuessed(guessedLetters, guess)){
                            totalGuesses++;
                            StdOut.println("You guessed " + guess);
                            if(checkLetter(userLetters, gameWord.toCharArray(), guess)){
                                StdOut.println(guess + " was in the word");
                                if(checkWin(userLetters)){
                                    break;
                                }
                            }
                            else{
                                wrongGuesses++;
                                StdOut.println(guess + " was not in the word");
                            }
                        }
                        else{
                            StdOut.println("You already guessed the letter " + guess + ", please enter another letter");
                        }
                    }
                    for(int i = 0; i < userLetters.length; i++){
                        StdOut.print(userLetters[i] + " ");
                    }
                    StdOut.print("\n\n");
                    StdOut.println("Hangman character:");
                    StdOut.println(printHangman(wrongGuesses));
                }
                if(!quit){
                    StdOut.println("Printing stats to " + args[1] + "...");
                    exportStats(userLetters, gameWord.toCharArray(), totalGuesses, wrongGuesses, args[1]);
                }
                else{
                    StdOut.println("Program exited");
                }
            }
        }
    }
    public static int validateChar(char inputChar){
        int ascii = (int) inputChar;
        if(ascii >= 97 && ascii <= 122){
            return ascii;
        }
        else if(ascii >= 65 && ascii <= 90){
            return ascii + 32;
        }
        else{
            return -1;
        }
    }
    public static String printHangman(int lives){
        return switch (lives) {
            case 0 -> """
                    
                    """;
            case 1 -> """
                    O
                    """;
            case 2 -> """
                    O
                    |
                    """;
            case 3 -> """
                    O
                    |\\
                    """;
            case 4 -> """
                    O
                   /|\\
                    """;
            case 5 -> """
                    O
                   /|\\
                   /
                    """;
            case 6 -> """
                    O
                   /|\\
                   / \\
                    """;
            default -> "";
        };
    }
}