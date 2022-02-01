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
                while(true) { // Roll, as many times as necessary, until you roll the point again (win) or a 7 (loss)
                    dice.roll();
                    roll = dice.getSum();
                    if (roll == point) {
                        wins+=1;
                        break;
                    } else if (roll == 7) {
                        losses+=1;
                        break;
                    }
                }
            }
        }
        //Print results
        System.out.println("Total iterations: " + iterations);
        System.out.println("Wins: " + wins);
        System.out.println("Lossses: " + losses);
    }
}