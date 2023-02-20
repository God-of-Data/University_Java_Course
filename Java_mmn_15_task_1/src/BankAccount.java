
import java.util.Objects;

public class BankAccount {

    private int accountID;

    private double balance;


    public BankAccount(int accountID, double balance) {

        this.setAccountID(accountID);
        this.setBalance(balance);
    }

    private void setAccountID(int accountID) {

        this.accountID = accountID;
    }

    private void setBalance(double balance) {

        this.balance = balance;
    }

    public int getAccountID() {

        return this.accountID;
    }

    /**
     * Executes transactions only if there is enough money in account,
     * and transaction is legal. Allows only one user to transact.
     *
     * @param amount money to be added/subtracted to/from account.
     */
    public synchronized void transaction(double amount) {

        String message =
                Thread.currentThread().getName() + " is going to transact " + amount + " to accountId: " + this.accountID + ". Bank balance is: " + balance();

        System.out.println(message);


        boolean transactionIsNotAllowed = amount + this.balance < 0;

        while(transactionIsNotAllowed) {

              try {

                  wait();
              }

              catch(InterruptedException e) {

                  e.printStackTrace();
              }

            transactionIsNotAllowed = amount + this.balance < 0;
        }

        this.balance += amount;

        message
                = Thread.currentThread().getName() + " completed the transaction of " + amount + " to accountId: " + this.accountID + ". Balance is: " + this.balance();

        System.out.println(message);
    }

    /**
     * Releasing all threads to continue transaction.
     *
     * @return current account balance.
     */
    public synchronized double balance() {

        notifyAll();

        return this.balance;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {

            return false;
        }

        BankAccount anotherBankAccount = (BankAccount) obj;

        boolean accountIdsAreIdentical
                = this.accountID == anotherBankAccount.accountID;

        return accountIdsAreIdentical;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.accountID);
    }
}
