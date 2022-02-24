public class Parallelogram implements FigureInterface {
    double base, height, angleInRad;

    public Parallelogram(double base, double height, double angleInRad) {
        this.base = base;
        this.height = height;
        this.angleInRad = angleInRad;
    }

    public double perimeter() {
        // make a right triangle to solve for the vertical parallel side w/ trig identities
        // sin(angle) = opposite / hypotenuse
        // hypotenuse = opposite / sin(angle)
        double hyp = height / Math.sin(angleInRad); // Math.sin() uses radians
        return (base + hyp) * 2;
    }

    public double area() {
        return base * height;
    }
    
}
