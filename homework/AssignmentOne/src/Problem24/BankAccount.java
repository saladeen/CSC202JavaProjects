package Problem24;
public class BankAccount {
    private int Ms; // 1-2-3-4-5-6-7-8 Ms in my BankAccount

    public BankAccount(int cashmoney) {
        Ms = cashmoney;
    }

    public int getTotal() {
        return Ms;
    }

    public void deposit(int bread) throws BankAccountException {
        if (bread < 0) {
            throw new BankAccountException("Tried to deposit a negative amount");
        }
        Ms += bread;
    }

    public void withdraw(int efectivo) throws BankAccountException {
        if (efectivo > Ms) {
            throw new BankAccountException("Tried to withdraw more than was in the account");
        } else if (efectivo < 0) {
            throw new BankAccountException("Tried to withdraw a negative amount");
        } else {
            Ms -= efectivo;
        }
    }

    public String toString() {
        return Integer.toString(Ms);
    }
}
