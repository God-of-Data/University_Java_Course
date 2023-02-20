import java.util.ArrayList;

public class TransactionList {

    private ArrayList<Transaction> transactions;

    public TransactionList() {

        this.transactions = new ArrayList<>();

    }

    /**
     * Add new transaction to list by creating a new task and adding it.
     *
     * @param accountID attribute of added task.
     * @param amount attribute of added task.
     */
    public void addTransaction(int accountID, double amount) {

        Transaction transaction = new Transaction(accountID, amount);

        this.transactions.add(transaction);

    }

    /**
     * Checking if transaction list is empty by checking the list's size.
     *
     * @return The first transaction.
     */
    public boolean isNotEmpty() {

        return this.transactions.size() > 0;
    }

    /**
     * Popping the first transaction in list and returning it.
     *
     * @return The first transaction.
     */
    public synchronized Transaction currentTransaction() {

        return this.transactions.remove(0);
    }
}
