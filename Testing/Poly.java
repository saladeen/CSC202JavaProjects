public class Poly {
    int degree;
    double[] coefficients;

    public Poly(int deg) {
        degree = deg;
        coefficients = new double[deg + 1];
    }

    public void setCoefficient(int exponent, int coefficient) {
        coefficients[exponent] = coefficient;
    }

    public double evaluate(double xval) {
        double total = 0;
        for (int i = 0; i < degree + 1; i++) {
            total += coefficients[i] * Math.pow(xval, i);
        }
        return total;
    }
}
