public class DataSync extends Data{

    private boolean isDone = false;

    public DataSync(int x, int y) {

        super(x, y);
    }

    /**
     * Calculates the difference of x,y attributes and prints it
     *
     * @return The absolute difference of the x,y attributes.
     */
    public synchronized int getDiff() {

        int tempDiff;

        /**
         * isDone represents if one function is done and another function can start.
         */
        while(!isDone) {

            try {

                wait();
            }

            catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }


        /**
         * Getting the difference.
         */
        tempDiff = super.getDiff();


        /**
         * Allowing other functions to start.
         */
        isDone = !isDone;

        /**
         * Waking up next threads.
         */
        notifyAll();

        return tempDiff;
    }

    /**
     * Adds given delta to x,y attributes and prints the updated object.
     * This method will be preformed only when getDiff method is done.
     * It's being checked by using isDone flag.
     *
     * @param dx delta to be added to x attribute.
     * @param dy delta to be added to y attribute.
     */
    public synchronized void update(int dx, int dy) {


        /**
         * Waiting for getDiff method to complete.
         */
        while(isDone) {

            try {

                wait();
            }

            catch(InterruptedException e) {

                e.printStackTrace();
            }
        }

        super.update(dx, dy);

        /**
         * Flag for next function performance to continue.
         */
        isDone = !isDone;

        /**
         * Waking up next threads.
         */
        notifyAll();
    }
}
