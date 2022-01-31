public class UseBankAccount {
    public static void main(String[] args) throws BankAccountException {
        testAcct();
        //depositNegative();
        //overdraw();
        //withdrawNegative();
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
