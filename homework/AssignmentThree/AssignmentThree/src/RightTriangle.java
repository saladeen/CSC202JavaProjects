public class RightTriangle implements FigureInterface {
    
    private double legA, legB;

    public RightTriangle(double legA, double legB) {
        this.legA = legA;
        this.legB = legB;
    }

    @Override
    public double perimeter() {
        double c = Math.pow( legA * legA + legB * legB, 0.5); // a^2 + b^2 = c^2
        return legA + legB + c;
    }

    @Override
    public double area() {
        return (legA * legB) / 2;
    }
}
