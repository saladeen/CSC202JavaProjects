import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) throws IOException {
        CollectionInterface<String> keywords = new ArrayCollection<String>(100);
        FileReader fin = new FileReader("src/keywords.txt");
        Scanner wordsIn = new Scanner(fin);

        String word;

        while (wordsIn.hasNext()) {
            word = wordsIn.next();          
            keywords.add(word);
        }
        System.out.println(keywords);

        String filename = args[0]; // "src/VocabularyDensity.java";
        FileReader fin2 = new FileReader(filename);
        Scanner kwIn = new Scanner(fin2);
        kwIn.useDelimiter("[^a-zA-Z']+");
        int totalKw = 0;

        while(kwIn.hasNext()) {
            word = kwIn.next();
            System.out.println(word);
            if (keywords.contains(word)) {
                totalKw++;
            }
        }
        System.out.println(filename + " contains " + totalKw + " keywords");
    }
}
