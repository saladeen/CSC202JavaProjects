public class Square implements FigureInterface {
    private double side;

    public Square(double sideLen) {
        side = sideLen;
    }

    public double perimeter() {
        return side * 4;
    }

    public double area() {
        return side * side;
    }

}
