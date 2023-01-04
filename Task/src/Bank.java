import java.util.ArrayList;

public class Bank {

    private ArrayList<Integer> free = new ArrayList<Integer>();

    public Bank(int size) {

        for (int i = 0; i < size; i++) {

            free.add(i);
        }
    }

    public synchronized int service(int tellerNum) {

        while ((!free.contains(tellerNum))) {

            try {

                wait();
            }

            catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }

        return free.remove(free.indexOf(tellerNum));
    }

    public synchronized void release(int teller) {

        free.add(teller);

        notifyAll();
    }

}


