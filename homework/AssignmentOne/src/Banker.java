import java.util.Scanner;

public class Banker {
    public static void main(String[] args) {
        BankAccount stacks = new BankAccount(1000000);
        System.out.println("Welcome to da bank. Select an option by entering its number:\n(1) Deposit\n(2) Withdrawal\n(3) View balance\n(4) Exit");
        Scanner sc = new Scanner(System.in);
        int selection = 0;

        while(true) {
            try {
                selection = sc.nextInt();
                if (selection == 1) {
                    System.err.println("How much would you like to deposit");
                    try {
                        
                    }
                } else if (selection == 2) {
                    System.out.println("How much would you like to withdraw");
                } else if (selection == 3) {
                    System.out.println(stacks);
                } else if (selection == 4) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Did not recognize that number - try again");
            }
        }
    }

}
