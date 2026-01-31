package wordgame;

import java.util.ArrayList;
import java.util.List;

class Word {

    private ArrayList<Character> letters;

    public Word(String value) {
        letters = new ArrayList<>();
        for (char c : value.toCharArray()) {
            letters.add(c);
        }
    }

    public Feedback compareTo(Word other) {
        int correctLetters = 0;
        int correctPositions = 0;

        List<Character> otherLetters = new ArrayList<>(other.letters);

        for (int i = 0; i < letters.size() && i < otherLetters.size(); i++) {
            if (letters.get(i).equals(otherLetters.get(i))) {
                correctPositions++;
                otherLetters.set(i, null);
            }
        }
        for (int i = 0; i < letters.size() && i < otherLetters.size(); i++) {
            char c = letters.get(i);
            if (otherLetters.contains(c)) {
                correctLetters++;
                otherLetters.set(otherLetters.indexOf(c), null);
            }
        }

        return new Feedback(correctLetters, correctPositions);
    }

    public int length() {
        return letters.size();
    }
}
