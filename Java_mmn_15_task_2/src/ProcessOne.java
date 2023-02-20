public class ProcessOne <T extends  Data> extends Thread {

    private static final int SLEEP_TIME = 100;

    private T dt;


    /**
     * Takes objet to use its update method in run method.
     *
     * @param dt object of  type Data or an extended class data.
     */
    public ProcessOne(T dt) {

        this.dt = dt;
    }

    /**
     * Creates 10 pairs of random numbers and each time update the dt attribute.
     * Sleeps determined amount of time between each iteration.
     */
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            //create random x,y numbers between 1....50

            /**
             * Creates 10 random x,y numbers between 1 and 50.
             */
            int x = (int) (Math.random() * (50) + 1);
            int y = (int) (Math.random() * (50) + 1);


            /**
             * Update object of type Data with new x,y using update method
             */
            dt.update(x, y);

            try {
                
                Thread.sleep(SLEEP_TIME);
            } 
            
            catch (InterruptedException e) {
                
                System.out.println("Error in ProcessOne %s%n" + e.getMessage());
            }
        }
    }

}
