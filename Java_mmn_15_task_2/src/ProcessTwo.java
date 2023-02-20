public class ProcessTwo <T extends Data> extends Thread {


    private static final int SLEEP_TIME = 100;


    private T dt;

    /**
     * Takes objet to use its update method in run method.
     *
     * @param dt object of  type Data or an extended class data.
     */
    public ProcessTwo(T dt){

        this.dt = dt;
    }


    /**
     * Calculates the difference of dt attribute 10 times.
     * Sleeps determined amount of time between each iteration.
     */
    @Override
    public void run() {

        int tempDiff;

        for (int i = 0; i < 10; i++) {

            /**
             * Gets the difference between x and y.
             */
            tempDiff = dt.getDiff();

            try {

                Thread.sleep(SLEEP_TIME);
            }

            catch (InterruptedException e) {

                System.out.println("Error in ProcessTwo %s%n" + e.getMessage());
            }
        }
    }


}
