import java.util.Scanner;

public class Banker {
    public static void main(String[] args) {
        BankAccount stacks = new BankAccount(1000000);
        Scanner sc = new Scanner(System.in);
        int selection = 0;

        while(true) {
            System.out.println("Welcome to da bank. Select an option by entering its number:\n(1) Deposit\n(2) Withdrawal\n(3) View balance\n(4) Exit");
            try {
                selection = sc.nextInt();
                if (selection == 1) {
                    System.err.println("How much would you like to deposit");
                    try_deposit(stacks, sc);
                } else if (selection == 2) {
                    System.out.println("How much would you like to withdraw");
                    try_withdraw(stacks, sc);
                } else if (selection == 3) {
                    System.out.println("Current balance: " + stacks);
                } else if (selection == 4) {
                    sc.close();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Did not recognize that number - try again");
                sc.nextLine();
            }
        }
    }

    public static int try_int(Scanner sc) {
        int input = 0;
        while(true) {
            try {
                input = sc.nextInt();
                break;
            } catch(Exception e) {
                System.out.println("Did not recognize that number - try again (must be an integer)");
                sc.nextLine();
            }
        }
        return input;
    }

    public static void try_deposit(BankAccount acct, Scanner sc) {
        while(true) {
            try {
                int amt = try_int(sc);
                acct.deposit(amt);
                System.out.println("Succesfully deposited $" + amt);
                System.err.println("Your balance is now: $" + acct.getTotal());
                break;
            } catch (BankAccountException e) {
                System.out.println("Error: " + e + ". Please enter again the amount you wish to deposit");
                sc.nextLine();
            }
        }
    }

    public static void try_withdraw(BankAccount acct, Scanner sc) {
        while(true) {
            try {
                int amt = try_int(sc);
                acct.withdraw(amt);
                System.out.println("Successfully withdrew $" + amt);
                System.out.println("Your balance is now: $" + acct.getTotal());
                break;
            } catch (BankAccountException e) {
                System.out.println("Error: " + e + ". Please enter again the amount you wish to withdraw");
                sc.nextLine();
            }
        }
    }

}
