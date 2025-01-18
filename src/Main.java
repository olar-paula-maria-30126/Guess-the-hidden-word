import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] wordList = {"java", "program", "developer", "keyboard", "monitor"};
        Random random = new Random();
        String wordToGuess = wordList[random.nextInt(wordList.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attemptsLeft = 6;
        boolean wordGuessed = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("\nCurrent word: " + String.valueOf(guessedWord));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter && guessedWord[i] == '_') {
                    guessedWord[i] = guessedLetter;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Wrong guess!");
            } else {
                System.out.println("Good guess!");
            }

            if (String.valueOf(guessedWord).equals(wordToGuess)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nGame over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
