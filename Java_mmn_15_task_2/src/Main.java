public class Main {

    public static void main(String[] args) {

        System.out.println("STARTING TASK NUMBER 1:");
        System.out.println();

        Data dt = new Data(0, 0);


        /**
         * Reference of 2 threads with Data object.
         */
        ProcessOne p1 = new ProcessOne(dt);
        ProcessTwo p2 = new ProcessTwo(dt);

        Thread p1Thread = new Thread(p1);
        Thread p2Thread = new Thread(p2);

        p1.start();
        p2.start();


        /**
         * Waiting for p1 and p2 to complete, and then printing message.
         */
        try {

            p1.join();
            p2.join();
        }

        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("END OF TASK NUMBER 1.");
        System.out.println();
        System.out.println("STARTING TASK NUMBER 2:");
        System.out.println();


        DataSync ds = new DataSync(0 , 0);

        ProcessOne p1Sync = new ProcessOne(ds);
        ProcessTwo p2Sync = new ProcessTwo(ds);

        Thread p1SyncThread = new Thread(p1Sync);
        Thread p2SyncThread = new Thread(p2Sync);

        p1SyncThread.start();
        p2SyncThread.start();

         /**
         * Waiting for p1SyncThread and p2SyncThread to complete, and then printing message.
         */
        try {

            p1SyncThread.join();
            p2SyncThread.join();
        }

        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("END OF TASK NUMBER 2.");
        System.out.println();
        System.out.println("STARTING TASK NUMBER 3:");
        System.out.println();


        DataSyncOne dsOne = new DataSyncOne(0,0);

        ProcessOne[] process1 = new ProcessOne[4];
        ProcessTwo[] process2 = new ProcessTwo[4];

        for (int i = 0; i < process1.length; i++) {

            process1[i] = new ProcessOne(dsOne);
            process1[i].start();
        }

        for (int i = 0; i < process2.length; i++) {

            process2[i] = new ProcessTwo(dsOne);
            process2[i].start();
        }

         /**
         * Waiting for all threads to complete, and then printing message.
         */
        try {

            for (int i = 0; i < process1.length; i++) {

                process1[i].join();
            }

            for (int i = 0; i < process2.length; i++) {

                process2[i].join();
            }
        }

        catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("END OF TASK NUMBER 3.");
    }
}