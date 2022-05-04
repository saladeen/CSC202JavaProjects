import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.SecureRandom;
import java.util.Scanner;

public class StringPairApp {
    public static void main(String[] args) throws FileNotFoundException {
        // Generate map of element numbers and names
        Scanner reader = new Scanner(new FileReader(new File("src/periodic.txt")));
        ArrayListMap<Integer, String> elementMap = new ArrayListMap<Integer, String>(); // element#, element
        
        reader.nextLine();
        
        while (reader.hasNext()) {
            String elementStr = reader.next();
            Integer elementNumber = Integer.parseInt(elementStr.substring(0, elementStr.length() - 1));
            String element = reader.next();
            elementMap.put(elementNumber, element);
        }

        int numberOfQuestions = 10;
        int correct = 0;
        SecureRandom srand = new SecureRandom();
        Scanner userIn = new Scanner(System.in);

        for (int i=0; i<numberOfQuestions; i++) {
            int randElement = srand.nextInt(1, 119); // inclusive, exclusive
            System.out.println("What's element " + randElement + "?");
            String guess = userIn.next().trim(); //get rid of newlines with trim()
            if (elementMap.get(randElement).equals(guess)) {
                correct++;
                System.out.println("Correct!");
            } else {
                System.out.println("Sorry, the correct answer was: " + elementMap.get(randElement));
            }
        }
        System.out.println("You guessed: " + correct + " elements correctly out of 10");
        
        reader.close();
        userIn.close();
    }
}
