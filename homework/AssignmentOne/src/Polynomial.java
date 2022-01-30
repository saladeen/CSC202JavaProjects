
public class Polynomial {
    int degree;
    double[] coefficients; // organization - index 0 = coefficient of degree 0 term... index 3 = coefficient of degree 3 term
    
    public Polynomial(int deg) {
        degree = deg;
        coefficients = new double[deg + 1]; // need 4 array spots for degree 3 polynomial, since it includes degree 0 (constants)
    }

    public Polynomial(double[] coefs) { // Constructor for part b
        coefficients = coefs;
        degree = coefs.length - 1;
    }

    public void setCoefficient(int exponent, int coef) {
        coefficients[exponent] = coef;
    }

    public double evaluate(double xval) {
        double total = 0.0;
        for (int i=0; i<degree+1; i++) {
            // total += xval ^ index (degree) * value of array at index (coefficient)
            // Math.pow(base, exponent), base = xval, exponent = index of array
            total += Math.pow(xval, i) * coefficients[i];
        }
        return total;
    }
}
