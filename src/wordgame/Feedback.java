package wordgame;

class Feedback {

    private int correctLetters;
    private int correctPositions;

    Feedback(int correctLetters, int correctPositions) {
        this.correctLetters = correctLetters;
        this.correctPositions = correctPositions;
    }

    @Override
    public String toString() {
        return "(" + correctLetters + ", " + correctPositions + ")";
    }

    public boolean isCorrect(Word word) {
        return correctPositions == word.length();
    }
}
