public class DiminishingSquares {
    public static void main(String[] args) {
        drawSquares(7);
    }
    public static void drawSquares(int side) {
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        if (side >= 1) {
            drawSquares(side);
        }
    }
}
