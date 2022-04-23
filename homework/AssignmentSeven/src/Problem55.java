import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem55 {
    public static void main(String[] args) throws FileNotFoundException {
        // WordFreq should be able to handle n-grams as the word is stored in a string

        String file = "src/the-full-bee-movie-script.txt";
        Scanner userIn = new Scanner(System.in);
        System.out.print("n-gram length:");
        int minLength = userIn.nextInt();
        System.out.print("\nMinimum n-gram frequency:");
        int minFreq = userIn.nextInt();

        FileReader fin = new FileReader(file);
        Scanner sc = new Scanner(fin);
        sc.useDelimiter("[^a-zA-Z']+");
        
        BinarySearchTree<WordFreq> tree = new BinarySearchTree<WordFreq>();


        String text = "";
        // throwing everything into a single string w/ spaces between
        while(sc.hasNext()) {
            String word = sc.next().toLowerCase();
            text += word + " ";
        }
        // easily split by spaces
        String[] words = text.split(" ");

        
        // then we combine n words together into WordFreq objects, and check for duplicates
        for (int i=0; i<words.length - minLength + 1; i++) {
            WordFreq gram = new WordFreq(concatN(words, i, i+minLength));
            WordFreq gramInTree = tree.get(gram);
            if (gramInTree != null) {
                gramInTree.inc();
            } else {
                gram.inc();
                tree.add(gram);
            }
        }

        System.out.println("The " + minLength + "-grams with frequency counts  of " + minFreq + " and above:");
        for (WordFreq word: tree) {
            if (word.getFreq() >= minFreq) {
                System.out.println(word);
            }
        }
    }

    public static String concatN(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i=start; i<end; i++) {
            sb.append((i > start ? " " : "") + words[i]); // elvis operator buffoonery
        }
        return sb.toString();
    }
}
