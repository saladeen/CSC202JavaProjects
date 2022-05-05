package Problem3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(new File("src/Problem3/input.txt")));
        HMap<String, Integer> wordsMap = new HMap<String, Integer>();
        boolean repeats = false;
        while(sc.hasNext()) {
            String word = sc.next();
            if(wordsMap.put(word, word.hashCode()) != null) {
                System.out.println(word + " repeats");
                repeats = true;
                break;
            }
        }
        if(!repeats) {
            System.out.println("No words repeat");
        }

    }
    
}
