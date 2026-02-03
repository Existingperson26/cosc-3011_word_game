package wordgame;

class Game {

    private Word secret;
    private WordList wordList;

    private void start() {}

    private Feedback makeGuess(String guess) {
        return null;
    }

    private void printFeedback(Feedback fb) {}

    public static void main(String[] args) {
        Word test = new Word("apple");
        Word other = new Word("apple");

        Feedback result = test.compareTo(other);

        System.out.println(result.toString());
    }
}
