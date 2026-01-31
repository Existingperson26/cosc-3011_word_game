package wordgame;

public class Feedback {

    private int correctLetters;
    private int correctPositions;

    public Feedback(int correctLetters, int correctPositions) {
        this.correctLetters = correctLetters;
        this.correctPositions = correctPositions;
    }

    @Override
    public String toString() {
        return "(" + correctLetters + ", " + correctPositions + ")";
    }

    public boolean isCorrect() {
        return correctLetters == correctPositions;
    }
}
