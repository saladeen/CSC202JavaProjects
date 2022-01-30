public class Polynomial {
    int degree;
    int[] coefficients; // organization - index 0 = coefficient of degree 0 term... index 3 = coefficient of degree 3 term
    
    public Polynomial(int deg) {
        degree = deg;
        coefficients = new int[deg];
    }

    public void setCoefficient(int exponent, int coef) {
        coefficients[exponent] = coef;
    }

    public double evaluate(double xval) {
        double total = 0.0;
        for (int i: coefficients) {
            // total += xval ^ index (degree) * value of array at index (coefficient)
            // Math.pow(base, exponent), base = xval, exponent = index of array
            total += Math.pow(xval, i) * coefficients[i];
        }
        return total;
    }
}
