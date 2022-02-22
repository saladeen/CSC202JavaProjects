public class Square implements FigureInterface {
    private double side;

    public Square(double sideLen) {
        side = sideLen;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }

    @Override
    public double area() {
        return side * side;
    }

}
