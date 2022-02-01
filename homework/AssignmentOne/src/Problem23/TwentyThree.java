package Problem23;
import java.util.Scanner;

public class TwentyThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an integer.");
        while(true) {
            try {
                sc.nextInt();
                System.out.println("Thank you");
                sc.close();
                break;
            } catch(Exception e) {
                System.out.println("That is not an integer. Try again");
                sc.nextLine(); // otherwise the Scanner will take the sysout line above
            }
        }
    }
}
