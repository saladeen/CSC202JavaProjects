package Problem13;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class PolynomialBC {
    public static void main(String[] args) {
        polyPartB(); // 13b
        //RiemannSummer(); // 13c
    }

    // The textbook has some WACK instructions for this part. They give an example where they say an input of "3 5 0 2 -3" should yield the polynomial 5x^3 + 2x - 3. Clearly,
    // they completely forgot about the x^4 term, it should be: 3x^4 + 5x^3 + 2x -3. So, if you want to verify the textbook's example numbers, input "0 5 0 2 -3" for the polynomial
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
        // Assuming a left-handed Riemann Sum
        // values needed: range, polynomial
    
        Scanner sc = new Scanner(System.in);
        Polynomial poly = new Polynomial(getPolyInput(sc));

        System.out.println("Enter the start of the range:");
        double min = sc.nextDouble();
        System.out.println("Enter the end of the range:");
        double max = sc.nextDouble();
        System.out.println("Enter how many rectangles to draw");
        double rectCount = sc.nextDouble();
        sc.close();

        double range = max - min;
        double rectXLength = range / rectCount;
        double rSum = 0;

        // Divide the range by the number of rectangles to draw to determine the length of the bottom (x-axis) side of each rectangle
        // Since we're drawing a left-handed sum, the length of the long (y-axis) side will be the value of f(x) where x is the x-value of the bottom left corner of the rectangle
        // So this starts at 0 and increments by rectXLength, and then is put into the polynomial to get the Y length, the rectXLength and Y are multiplied together to determine the area of that rectangle
        // Then repeat incrementing by rectXLength and adding to a total area calculation

        // value of i gets plugged into the solver, then multiplied by rectXLength to get the area of that rectangle
        for (double i=0.0; i<range; i = i + rectXLength) {
            rSum += poly.evaluate(i) * rectXLength;
        }
    
        System.out.println(rSum);
    }
}
