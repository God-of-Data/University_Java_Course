public class Transaction {

    private int accountId;

    private double amount;

    public Transaction(int accountId, double amount) {

        this.setAccountId(accountId);
        this.setAmount(amount);
    }

    private void setAccountId(int accountId) {

        this.accountId = accountId;
    }

    private void setAmount(double amount) {

        this.amount = amount;
    }

    public int getAccountId() {

        return this.accountId;
    }

    public double getAmount() {

        return this.amount;
    }

    @Override
    public String toString() {
        return "Transaction{"
                    + "accountId=" + this.getAccountId()
                    + ", amount=" + this.getAmount()
                    + '}';
    }
}
