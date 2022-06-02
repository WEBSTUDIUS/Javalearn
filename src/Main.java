import java.util.Scanner;

public class Main {
        static String word = "javalove";
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Guess a word");
        int lenghtWord = word.length();
        String maskWord = "-".repeat(lenghtWord);
        System.out.println(maskWord);

        do {
            System.out.println("Input a letter");
            char sym = input.next().charAt(0);
            System.out.println(maskWord);
            if (word.indexOf(sym) >= 0) {
                System.out.println("Yep!");
//                maskWord = "";
                for (char elem: word.toCharArray()) {
                    if (elem == sym) {
//                        maskWord+=elem;
//                    } else {
//                        maskWord+="-";
                        maskWord = replaceMaskedLetter(sym, maskWord);
                    }
                }
                System.out.println(maskWord);
            } else {
                System.out.println("Try again");
            }
        } while (maskWord.contains("-"));
        System.out.println("Congratulations! You're win!");
    }

    public static String replaceMaskedLetter(char sym, String maskWord){
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
