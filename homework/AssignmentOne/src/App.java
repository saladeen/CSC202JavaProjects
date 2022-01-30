import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class App {
    
    public static void main(String[] args) throws Exception {
        testing();
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

    public static void polyPartB() {
        Scanner sc = new Scanner(System.in);
        double[] test = getPolyInput(sc);
        
        Polynomial poly = new Polynomial(test);


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
        double[] inputAsDouble = Stream.of(input).mapToDouble(Double::parseDouble).toArray();
        return inputAsDouble;
    }

    public static void RiemannSummer() {
        System.out.println("Enter a ");
    }

    public static void testing() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coefficients of a polynomial, like this: 3 5 0 2 -3");
        String[] input = sc.nextLine().split(" ", 0);
        List<String> test = Arrays.asList(input);
        double[] inputAsDouble = Stream.of(input).mapToDouble(Double::parseDouble).toArray();

        int len = inputAsDouble.length;
        double[] reversed = new double[len];
        for (int i=len-1; i>=0; i++) {
            
        }
    }
}
