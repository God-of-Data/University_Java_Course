public class DataSyncOne extends Data{

    private boolean getDiffLock = true;

    private boolean updateLock = false;

    public DataSyncOne(int x, int y) {

        super(x, y);
    }

    /**
     * Calculates the difference of x,y attributes and prints it
     *
     * @return The absolute difference of the x,y attributes.
     */
    public synchronized int getDiff(){

        int tempDiff;

        /**
         * updateLock flag is false until all getDiff threads are done
         */
        while(updateLock) {

            try {

                wait();
            }

            catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }

        tempDiff = super.getDiff();

        /**
         * getDiff is done therefore getDiffLock flag is being set as false
         */
        getDiffLock = false;

        notifyAll();

        return tempDiff;
    }

    /**
     * Adds given delta to x,y attributes and prints the updated object.
     * This method will be preformed only when getDiff method is done.
     * It's being checked by using getDiffLock,updateLock flags.
     *
     * @param dx delta to be added to x attribute.
     * @param dy delta to be added to y attribute.
     */
    public synchronized void update(int dx, int dy) {

        /**
         * Only when updateLock is true => wait mode in getDiff => no getDiff operation.
         */
        while(getDiffLock || updateLock) {

            try {

                wait();
            }

            catch(InterruptedException e) {

                e.printStackTrace();
            }
        }

        /**
         * Changing state of updateLock to allow Data update.
         */
        updateLock = true;

        super.update(dx, dy);

        /**
         * Changing state of updateLock to complete Data update.
         */
        updateLock = false;

        /**
         * Waking up next threads.
         */
        notifyAll();
    }
}
