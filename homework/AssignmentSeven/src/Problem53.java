import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem53 {
    public static void main(String[] args) throws FileNotFoundException {
        
        String file = "src/input.txt";//args[0]; // test file: src/input.txt
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

        String mostFrequent = "";
        int largestFreq = 0;
        for (WordFreq wordFromTree: tree) { // im sure there are better ways to do this
            if(wordFromTree.getFreq() > largestFreq) {
                mostFrequent = wordFromTree.getWordIs();
                largestFreq = wordFromTree.getFreq();
            }
        }
        System.out.println("Most frequent word is: " + mostFrequent + ", occuring " + largestFreq + " times.");
        
        sc.close();
    }
}
