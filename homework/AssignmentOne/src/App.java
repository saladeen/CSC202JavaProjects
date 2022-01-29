public class App {
    
    public static void main(String[] args) throws Exception {
        testDriver();
    }

    //'test driver' since idk how to generate tests in vscode 
    public static void testDriver() {
        PairOfDice p = new PairOfDice();
        p.roll();
        System.out.println(p.toString());
    }

    public static void craps_sim() {
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
        }
    }
}
