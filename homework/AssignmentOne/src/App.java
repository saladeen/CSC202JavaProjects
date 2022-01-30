import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class App {
    
    public static void main(String[] args) throws Exception {
        polyPartB();
    }

    //'test driver' since idk how to generate tests in vscode 
    public static void testDriver() {
        PairOfDice p = new PairOfDice();
        p.roll();
        System.out.println(p.toString());
    }

    public static void craps_sim() {
        int iterations = 100000;
        int wins = 0;
        int losses = 0;
        PairOfDice dice = new PairOfDice();
        int point = 0;
        /*
        Pass Line
        An even money bet, made on the first roll of the dice (known as the “come out roll”). 
        You win if a 7 or 11 roll, or lose if 2, 3, or 12 roll (known as “craps”). 
        Any other number that rolls becomes the “point” and the point must roll again before a 7 to win.
        */
        // may honestly be better to use if statements... switch statements are unnecessarily restrictive
        for (int i=0; i<iterations; i++) {
            dice.roll();
            int roll = dice.getSum();
            if (roll == 7 || roll == 11) { //win
                wins+=1;
            } else if (roll == 2 || roll == 3 || roll == 12) { //loss
                losses+=1;
            } else {
                point = roll; // Set the point
                boolean outcome = roll_until_point(point, wins, losses, dice); //Roll until you either get the point and win, or roll a 7 and lose. True = won, False = lost
                if (outcome) {
                    wins+=1;
                } else {
                    losses+=1;
                }
            }
        }

        //Print results
        System.out.println("Total iterations: " + iterations);
        System.out.println("Wins: " + wins);
        System.out.println("Lossses: " + losses);
    }

    public static boolean roll_until_point(int point, int wins, int losses, PairOfDice dice) {
        int roll = 0;

        while (roll != 7 || roll != point) {
            dice.roll();
            roll = dice.getSum();
            if (roll == 7) {
                return false;
            } else if (roll==point) {
                return true;
            }
        }
        
        // these lines should never actually run but needed to shut up the compiler
        System.out.println("you done messed up A-A-Ron");
        return false;
    }

    public static void shoppingBagDriver() {
        ShoppingBag bag = new ShoppingBag(0.06); //tax = 6%
        int count = 1;
        Scanner sc  = new Scanner(System.in);

        while(count != 0) {
            System.out.println("Enter count (use 0 to stop):");
            count = sc.nextInt();
            System.out.println("Enter cost: ");
            double cost = sc.nextDouble();
            bag.place(count, cost);
        }
        System.out.println(bag.toString());
        sc.close();
    }

    public static void polynomialDriver() {
        Polynomial nom = new Polynomial(3);
        nom.setCoefficient(3, 5);
        nom.setCoefficient(1, 2);
        nom.setCoefficient(0, -3);

        System.out.println(nom.evaluate(0.0));
        System.out.println(nom.evaluate(1.0));
        System.out.println(nom.evaluate(0.5));

    }

    // The textbook has some WACK instructions for this part. They give an example where they say an input of "3 5 0 2 0 -3" should yield the polynomial 5x^3 + 2x - 3. Clearly,
    // they completely forgot about the x^4 term, it should be: 3x^4 + 5x^3 + 2x -3. So, if you want to verify the textbook's example numbers, input "0 5 0 2 0 -3" for the polynomial
    // instead of what they wrote. 
    public static void polyPartB() {
        Scanner sc = new Scanner(System.in);
        Polynomial poly = new Polynomial(getPolyInput(sc));


        while(true) {
            System.out.println("Now enter a value (for x) to evaluate the polynomial:");
            System.out.println( poly.evaluate( sc.nextDouble() ) );
            System.out.println("Keep going? y/n");
            String y_n = sc.next();
            if (y_n.equals("n")) {
                break;
            }
        }
        sc.close();
    }

    // Array needs to be REVERSED! Otherwise the class will interpret index 0 as degree 0, NOT degree 5 like it should be
    public static double[] getPolyInput(Scanner sc) {
        System.out.println("Enter the coefficients of a polynomial, like this: 3 5 0 2 -3");
        String[] input = sc.nextLine().split(" ", 0);
        List<String> inputList = Arrays.asList(input);
        Collections.reverse(inputList);
        double[] inputAsDouble = Stream.of(inputList.toArray(new String[0])).mapToDouble(Double::parseDouble).toArray(); // there are definitely better ways to do this but I don't care
        return inputAsDouble;
    }

    public static void RiemannSummer() {
        // Assuming a midpoint Riemann Sum
        // values needed: range, polynomial
        // 
        System.out.println("Enter a ");
    }
}
