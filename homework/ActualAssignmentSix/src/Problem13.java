import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) throws IOException {
        final int CAP = 1000;
        String filename = "src/Animals.txt";
        boolean running = true;
        String word;
        SecureRandom srand = new SecureRandom();

        CollectionInterface<String> animals = new ArrayCollection<String>(CAP);
        FileReader fin = new FileReader(filename);
        Scanner wordsIn = new Scanner(fin);

        while (wordsIn.hasNext()) {
            word = wordsIn.nextLine();          
            word = word.toLowerCase();
            if (!animals.contains(word)) {
                animals.add(word);
            }
        }


        Scanner userIn = new Scanner(System.in);
        int correctGuesses = 0;

        CollectionInterface<String> guesses = new ArrayCollection<String>(CAP);

        while(running) {
            char curr = (char)(srand.nextInt(26) + 'a');
            System.out.println("Guess a unique animal that starts with: " + curr);
            String guess = userIn.nextLine();
            if (animals.contains(guess) && guess.charAt(0) == curr && !guesses.contains(guess)) {
                System.out.println("Correct!");
                guesses.add(guess);
                correctGuesses++;
            } else {
                System.out.println("Sorry, not in the list, wrong letter, or you already guessed that. Game over.");
                break;
            }
        }
        System.out.println("You guessed " + correctGuesses + " animals correctly");
        
    }
}
