import java.util.*;

public class Main {
    static HashMap<String, String> wordsArray = new HashMap<String, String>();

    public static void main(String[] args) {
        wordsArray.put("javascript","A scripting or programming language that allows you to implement complex features on web pages");
        String word = "";
        String descr = "";
        for(Map.Entry<String, String> item : wordsArray.entrySet()){

            word = item.getKey();
            descr = item.getValue();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Guess a word: " + descr);
        int lenghtWord = word.length();
        String maskWord = "-".repeat(lenghtWord);
        System.out.println(maskWord);

        do {
            System.out.println("Input a letter (or word)");
            String typedWord = input.next();
            if (typedWord.length() > 1) {
                if (Objects.equals(typedWord, word)) {
                    maskWord = word;
                } else {
                    System.out.println("Try again");
                    continue;
                }
            } else {
                char sym = typedWord.charAt(0);
                System.out.println(maskWord);
                if (word.indexOf(sym) >= 0) {
                    System.out.println("Yep!");
//                maskWord = "";
                    for (char elem : word.toCharArray()) {
                        if (elem == sym) {
//                        maskWord+=elem;
//                    } else {
//                        maskWord+="-";
                            maskWord = replaceMaskedLetter(sym, maskWord, word);
                        }
                    }
                    System.out.println(maskWord);
                } else {
                    System.out.println("Try again");
                }
            }
        } while (maskWord.contains("-"));
        System.out.println("Congratulations! You're win!");
    }

    public static String replaceMaskedLetter(char sym, String maskWord, String word){
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == sym) {
                newString.append(sym);
            } else if (maskWord.charAt(i) != '-') {
                newString.append(maskWord.charAt(i));
            } else {
                newString.append("-");
            }
        }
        return newString.toString();
    }

}