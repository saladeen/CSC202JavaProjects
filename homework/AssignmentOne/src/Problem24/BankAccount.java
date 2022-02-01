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

class UseBankAccount {
    public static void main(String[] args) throws BankAccountException {
        testAcct();
        // depositNegative();
        // overdraw();
        // withdrawNegative();
    }

    public static void testAcct() throws BankAccountException {
        BankAccount ms = new BankAccount(12345678);
        ms.withdraw(1337);
        System.out.println(ms);
        ms.withdraw(420000);
        System.out.println(ms);
        ms.deposit(6969);
        System.out.println(ms);
    }

    public static void depositNegative() throws BankAccountException {
        BankAccount stash = new BankAccount(100);
        stash.deposit(-100);
    }

    public static void overdraw() throws BankAccountException {
        BankAccount loot = new BankAccount(6969);
        loot.withdraw(10000);
    }

    public static void withdrawNegative() throws BankAccountException {
        BankAccount m = new BankAccount(1234);
        m.withdraw(-1);
    }
}

