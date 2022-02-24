public class IsocelesTriangle implements FigureInterface {
    private double height, base;

    public IsocelesTriangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double perimeter() {
        // length of (one of the) two equal sides determined by solving pythagorean for the right triangle created by splitting the isoceles down the middle
        double halfBase = base/2;
        double equalSide = Math.pow(halfBase * halfBase + height * height, 0.5);

        return base + 2 * equalSide;
    }

    public double area() {
        return (base * height) / 2;
    }

    
}
