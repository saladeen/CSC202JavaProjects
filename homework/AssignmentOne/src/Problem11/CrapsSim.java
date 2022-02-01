package Problem11;
public class CrapsSim {

    public static void main(String[] args) {

        int iterations = 100000;
        int wins = 0;
        int losses = 0;
        PairOfDice dice = new PairOfDice();
        int point = 0;

        /*
            Pass Line
            An even money bet, made on the first roll of the dice (known as the “come out roll”). 
            You win if a 7 or 11 roll, or lose if 2, 3, or 12 roll (known as “craps”). 
            Any other number that rolls becomes the “point” and the point must roll again before a 7 to win.
        */
    
        for (int i=0; i<iterations; i++) {
            dice.roll();
            int roll = dice.getSum();
            if (roll == 7 || roll == 11) { //win
                wins+=1;
            } else if (roll == 2 || roll == 3 || roll == 12) { //loss
                losses+=1;
            } else {
                point = roll; // Set the point
                boolean outcome = roll_until_point(point, wins, losses, dice); //Roll until you either get the point and win, or roll a 7 and lose. True = won, False = lost
                if (outcome) {
                    wins+=1;
                } else {
                    losses+=1;
                }
            }
        }

        //Print results
        System.out.println("Total iterations: " + iterations);
        System.out.println("Wins: " + wins);
        System.out.println("Lossses: " + losses);
    }

    public static boolean roll_until_point(int point, int wins, int losses, PairOfDice dice) {
        int roll = 0;

        while (roll != 7 || roll != point) {
            dice.roll();
            roll = dice.getSum();
            if (roll == 7) {
                return false;
            } else if (roll==point) {
                return true;
            }
        }
        // this line should never actually run but is needed to shut up the compiler
        return false;
    }

}