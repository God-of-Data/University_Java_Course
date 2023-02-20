
import java.util.HashMap;
import java.util.Random;

public class BankTeller implements Runnable {

    private final static int MAX_SLEEP_TIME = 100;

    private TransactionList transactions;

    private HashMap<Integer,BankAccount> bankAccounts;


    public BankTeller(TransactionList transactions, HashMap<Integer,BankAccount> bankAccounts) {

        this.setTransactions(transactions);
        this.setBankAccounts(bankAccounts);
    }

    private void setTransactions(TransactionList transactions) {

        this.transactions = transactions;
    }

    private void setBankAccounts(HashMap<Integer, BankAccount> bankAccounts) {

        this.bankAccounts = bankAccounts;
    }


    /**
     * Takes new transaction and moves on only if transaction was completed.
     */
    @Override
    public void run() {

        Random generator = new Random();

        while(transactions.isNotEmpty()) {

            /**
             * Taking the first unattended transaction, and its details.
             */
            Transaction currentTransaction = this.transactions.currentTransaction();

            BankAccount currentBankAccount = this.bankAccounts.get(currentTransaction.getAccountId());

            /**
             * Executing current transaction.
             */
            currentBankAccount.transaction(currentTransaction.getAmount());

            try {

                /**
                 * Sleeping random time.
                */
                Thread.sleep(generator.nextInt(MAX_SLEEP_TIME));
            }

            catch (InterruptedException e) {

                throw new RuntimeException(e);

            }
        }
    }
}
