
import java.util.HashMap;

public class Main {



    public static TransactionList generateRandomTransactionList(BankAccount[] bankAccount) {

        final int TOTAL_TRANSACTION_NUM = 50;


        int randomAmount, j = 0, k = 0;;

        TransactionList transactions = new TransactionList();


        /**
         * Creating list with 50 different transactions.
         */
        while(j < TOTAL_TRANSACTION_NUM) {

            /**
             * Each bank account with 10 transactions.
             */
            if(k < bankAccount.length ) {


                /**
                 * Generating random numbers in range of [-1000, 1000].
                 */
                randomAmount = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));;

                transactions.addTransaction(bankAccount[k].getAccountID(), randomAmount);

                k += 1;

                j += 1;
            }

            else {

                k = 0;
            }
        }

        return transactions;
    }

    public static void main(String[] args) {


        final int NUM_OF_ACCOUNTS = 5;
        final int NUM_OF_TELLERS = 10;



        BankAccount[] bankAccount = new BankAccount[NUM_OF_ACCOUNTS];

        /**
         * Initiating 5 bank accounts with id's o: 0...4 and balance of 0.
         */
        for (int i = 0; i < bankAccount.length; i++) {

            bankAccount[i] = new BankAccount(i, 0);
        }


        HashMap<Integer,BankAccount> bankAccounts = new HashMap<>();

        for (int i = 0; i < bankAccount.length; i++) {

            bankAccounts.put(bankAccount[i].getAccountID(), bankAccount[i]);
        }


        TransactionList transactions = generateRandomTransactionList(bankAccount);


        /**
         * Creating a list of 10 bank tellers.
         */
        BankTeller[] bankTellerList = new BankTeller[NUM_OF_TELLERS];

        for (int i = 0; i < bankTellerList.length; i++) {

            bankTellerList[i] = new BankTeller(transactions, bankAccounts);
        }


        Thread[] bankTellerThreads = new Thread[NUM_OF_TELLERS];

        /**
         * Creating a list of 10 threads with BankTeller objects.
         */
        for (int i = 0; i < bankTellerThreads.length; i++) {

            bankTellerThreads[i] = new Thread((bankTellerList[i]));
        }


        /**
         * Starting all 10 threads.
         */
        for (int i = 0; i < bankTellerThreads.length; i++) {

            bankTellerThreads[i].start();
        }
    }
}