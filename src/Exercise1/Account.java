package Exercise1;

public class Account {
    public static Account account;
    private static int balance = 1000;
    private static AccountHolder AccountHolder;
    private Account() {
    }
    public static Account getAccount(AccountHolder p) {
        if (account == null) {
            account = new Account();
        }
        Account.AccountHolder = p;
        return account;
    }
    public static int getBal() {
        return balance;
    }
    public synchronized void withdraw(int bal) {
        try {
            if (balance >= bal) {
                System.out.println(AccountHolder.getName() + " " + "is  withdrawing...");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance - bal;
                System.out.println(AccountHolder.getName() + " " + "withdrawl is complete.");
            } else {
                System.out.println(AccountHolder.getName() + " " + "has insufficient funds. ");
            }
            System.out.println(AccountHolder.getName() + " " + " completed a withdrew of: $" + bal + " Current balance: $"+ balance);
           
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized void deposit(int bal) {
        try {
            if (bal > 0) {
                System.out.println(AccountHolder.getName() + " " + " is depositing...");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance + bal;
                System.out.println(AccountHolder.getName() + " " + "deposit is complete.");
               
            } else {
                System.out.println(AccountHolder.getName() + " " + "has insufficient funds to deposit.");
            }
            System.out.println(AccountHolder.getName() + " " + " deposited a toal of: $" + bal + " Current balance: $" + balance);
           
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}