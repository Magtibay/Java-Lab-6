package Exercise1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountTest extends Thread implements Runnable {
    private AccountHolder AccountHolder;
    public AccountTest(AccountHolder p) {
        this.AccountHolder = p;
    }
    public synchronized static void main(String[] args) {
        AccountTest Client1 = new AccountTest(new AccountHolder("John Johnson"));
      
        AccountTest Client2 = new AccountTest(new AccountHolder("Megan Fox"));
        
        AccountTest Client3 = new AccountTest(new AccountHolder("Will Smith"));
        
        
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(Client1);
        executorService.execute(Client2);
        executorService.execute(Client3);
        
        executorService.shutdown();
        
    }
    
    @Override
    public synchronized void run() {
    	
    	
        for (int i = 0; i < 3; i++) {
            try {
                Account acc = Account.getAccount(AccountHolder);
                acc.withdraw(100);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AccountTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (Account.getBal() < 0) {
                    System.out.println("account is in overdraw!");
                }
                acc.deposit(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("The account balance of " + AccountHolder.getName() + " is $" + Account.getBal());
       
    }
}


