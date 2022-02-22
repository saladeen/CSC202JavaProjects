public class IsocelesTriangle implements FigureInterface {
    double height, base;

    public IsocelesTriangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double perimeter() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }

    
}
