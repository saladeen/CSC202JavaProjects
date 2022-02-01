package Problem11;
import java.security.SecureRandom;

public class PairOfDice {
    private int diceOne;
    private int diceTwo;

    public PairOfDice() {
        // setting initially but roll() should be called before toString()
        diceOne = 0;
        diceTwo = 0;
    }

    public void roll() {
        SecureRandom rand = new SecureRandom();
        diceOne = rand.nextInt(6) + 1; // 0-5, +1 -> 1-6
        diceTwo = rand.nextInt(6) + 1;
    }

    public String toString() {
        return diceOne + " : " + diceTwo + " = " + (diceOne+diceTwo);
    }

    public int getSum() {
        return diceOne + diceTwo;
    }
}

class DiceDriver {
    public static void main(String[] args) {
        PairOfDice p = new PairOfDice();
        p.roll();
        System.out.println(p);
    }
}
