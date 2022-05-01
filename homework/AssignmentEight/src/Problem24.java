import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] famousHash = new int[23];
        int arrPos = 0;
        Scanner sc = new Scanner(new FileReader(new File("src/FamousCS.txt")));
        sc.useDelimiter("[,\\n]");
        while(sc.hasNext()) {
            // first name, last name, DOB, fact
            String first = sc.next();
            String last = sc.next();
            int dob = sc.nextInt();
            String fact = sc.next();
            FamousPerson person = new FamousPerson(first, last, dob, fact);
            famousHash[arrPos] = person.hashCode();
            arrPos++;
        }
        Arrays.sort(famousHash); 
        System.out.println("Original hashes:");
        for (int hash: famousHash) {
            System.out.println(hash);
        }
        System.out.println("Hashes % 1000");
        for (int hash: famousHash) {
            System.out.println(hash % 1000);
        }
        System.out.println("Hashes % 100");
        for (int hash: famousHash) {
            System.out.println(hash % 100);
        }
        System.out.println("Hashes % 10");
        for (int hash: famousHash) {
            System.out.println(hash % 10);
        }
    }
}
