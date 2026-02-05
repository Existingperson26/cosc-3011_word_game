import java.util.*;


public class Project {
    public static void main(String[] args) {

        Random r = new Random();
        List<String> wordList = getWords();
        int guesses = 0;
        int listSize = wordList.size();
        int randomWord = r.nextInt(listSize);
        String selectedWord = wordList.get(randomWord);
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("Enter a " + selectedWord.length() + "-letter word to guess.");
            String userWord = input.nextLine();
            while (userWord.length() != selectedWord.length()){
                System.out.println("Input invalid! Please enter a " + selectedWord.length() + "-letter word to guess!");
                userWord = input.nextLine();
            }
            int corAnywhere = correctLetters(selectedWord, userWord);
            int corPosition = correctLetterPosition(selectedWord, userWord);

            System.out.println("Matching letters: " + (corAnywhere - corPosition));
            System.out.println("Correct positions: " + corPosition);

            if (userWord.equalsIgnoreCase(selectedWord)){
                System.out.println("You guessed the word in " + guesses + " guesses! Congrats!");
                break;
            }
            guesses++;
        }
    }

    public static List<String> getWords(){
        //List<String> list = Arrays.asList("apple");

        List<String> list = Arrays.asList("cat","fun","apple","laugh","orange","banana","laptop","school","window","giraffe","diamond","picture","planet","rocket","summer","jungle","butter","castle","forest","monster","silver","bottle","pencil","garden","helmet","mirror","button","bridge","coffee","tunnel");
        return list;
    }

    public static List<String> itemizer(String word){
        List<String> splitWord = new ArrayList<>();
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            splitWord.add(Character.toString(letter));
        }
        return splitWord;
    }

    public static int correctLetterPosition(String selectedWord, String userWord){
        int posLetters = 0;
        selectedWord = selectedWord.toLowerCase();
        userWord = userWord.toLowerCase();
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == userWord.charAt(i)){
                posLetters++;
            }
        }
        return posLetters;
    }

    public static int correctLetters(String selectedWord, String userWord){
        List<String> targetLetters = itemizer(selectedWord.toLowerCase());
        int corLetters = 0;

        for (int i = 0; i < selectedWord.length(); i++){
            String letter = Character.toString(userWord.toLowerCase().charAt(i));
            if (targetLetters.contains(letter)){
                corLetters++;
                targetLetters.remove(letter);
            }
        }
        return corLetters;
    }
}