package wordgame;

import java.util.ArrayList;

class Word {

    private ArrayList<Character> letters;

    Word(String str) {
        letters = new ArrayList<>();

        for (char c : str.toLowerCase().toCharArray()) {
            letters.add(c);
        }
    }

    public Feedback compareTo(Word other) {}

    public int length() {
        return letters.size();
    }
}
