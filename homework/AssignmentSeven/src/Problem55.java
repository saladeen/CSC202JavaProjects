import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem55 {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/input.txt"; // test file: src/input.txt
        Scanner userIn = new Scanner(System.in);
        System.out.print("n-gram length:");
        int minLength = userIn.nextInt();
        System.out.print("\nMinimum n-gram frequency:");
        int minFreq = userIn.nextInt();

        FileReader fin = new FileReader(file);
        Scanner sc = new Scanner(fin);
        sc.useDelimiter("[^a-zA-Z']+");
        
        BinarySearchTree<WordFreq> tree = new BinarySearchTree<WordFreq>();
        
        while(sc.hasNext()) {
            WordFreq word = new WordFreq(sc.next().toLowerCase());
            WordFreq wordInTree = tree.get(word);
            if (wordInTree != null) {
                wordInTree.inc();
            } else {
                word.inc();
                tree.add(word);
            }
            
        }

        String longestWord = "";
        int count = 0;
        for (WordFreq wordFromTree: tree) { // im sure there are better ways to do this
            if(wordFromTree.getWordIs().length() > longestWord.length()) {
                longestWord = wordFromTree.getWordIs();
                count = wordFromTree.getFreq();
            }
        }
        System.out.println("Longest word is: " + longestWord + ", occuring " + count + " times.");

        userIn.close();
        sc.close();
    }
}
