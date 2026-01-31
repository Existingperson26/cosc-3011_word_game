package wordgame;

import java.util.List;
import java.util.Scanner;
import wordgame.Feedback;

public class Game {

    private Word secret;
    private WordList wordList;

    public void start() {
        List<String> words = List.of(
            "Apple",
            "Brave",
            "Crown",
            "Flame",
            "Globe",
            "Hasty",
            "Jolly",
            "Knock",
            "Lunar",
            "Mirth",
            "Noble",
            "Oasis",
            "Plumb",
            "Quest",
            "Royal",
            "Slate",
            "Trace",
            "Unity",
            "Vigor",
            "Whale",
            "Xerus",
            "Youth",
            "Zebra",
            "Blunt",
            "Crisp",
            "Drift",
            "Elbow",
            "Fancy",
            "Grape",
            "Hazel"
        );

        wordList = new WordList(words);
        secret = wordList.getRandom();
    }

    public void makeGuess(String guess) {
        Word guessWord = new Word(guess);
        Feedback fb = guessWord.compareTo(secret);
        printFeedback(fb);

        if (fb.isCorrect()) {
            System.out.println("Congratulations! You guessed the word!");
        }
    }

    public void printFeedback(Feedback fb) {
        System.out.println(fb);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        Scanner scanner = new Scanner(System.in);
        boolean guessedCorrect = false;

        while (!guessedCorrect) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();

            Word guessWord = new Word(input);
            Feedback fb = guessWord.compareTo(game.secret);
            game.printFeedback(fb);

            if (fb.isCorrect()) {
                System.out.println("YOU WIN!");
                guessedCorrect = true;
            }
        }

        scanner.close();
    }
}
