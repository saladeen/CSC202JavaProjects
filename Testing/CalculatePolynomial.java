import java.util.Scanner;
public class CalculatePolynomial {
    public static void main(String[] args) {
        //partA();
        //partB();
        partC();
    }

    public static void partA() {
        Poly polynomial = new Poly(3);
        polynomial.setCoefficient(3, 5);
        polynomial.setCoefficient(1, 2);
        polynomial.setCoefficient(0, -3);

        System.out.println(polynomial.evaluate(0.0));
        System.out.println(polynomial.evaluate(1.0));
        System.out.println(polynomial.evaluate(0.5));
    }

    public static void partB() {
        Scanner sc = new Scanner(System.in);
        Poly inputPoly = parseInput();

        while(true) {
            System.out.println("Enter a value for x to evaluate");
            double value = sc.nextDouble();
            System.out.println(inputPoly.evaluate(value));
            System.out.println("Keep going? Y/n");
            String response = sc.next();
            if (response.equals("n")) {
                break;
            }
        }
        sc.close();
    }

    public static Poly parseInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a polynomial, first term degree, next coefficients");
        String input = sc.nextLine();
        String[] inputSplit = input.split(" ");
        int degree = Integer.parseInt(inputSplit[0]);

        Poly inputPoly = new Poly(degree);

        int newCounter = inputSplit.length - 1;
        for (int i=0; i<inputSplit.length - 1; i++) {
            inputPoly.setCoefficient(i, Integer.parseInt(inputSplit[newCounter]));
            newCounter--;
        }
        return inputPoly;
    }

    public static void partC() {
        // Assuming a left-handed Riemann Sum
        // values needed: range, polynomial
    
        Scanner sc = new Scanner(System.in);
        Poly poly = parseInput();

        System.out.println("Enter the start of the range:");
        double min = sc.nextDouble();
        System.out.println("Enter the end of the range:");
        double max = sc.nextDouble();
        double rectCount = 1000;
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
