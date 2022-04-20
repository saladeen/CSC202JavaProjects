import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class Problem28 {
    public static void main(String[] args) throws IOException {
        SortedABList<String> words = new SortedABList<String>();
        FileReader fin = new FileReader("src/Problem28.txt");
        Scanner sc = new Scanner(fin);
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        System.out.println(words);
        sc.close();
    }
}
