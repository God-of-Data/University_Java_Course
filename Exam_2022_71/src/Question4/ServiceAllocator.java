package Question4;

import java.util.*;

public class ServiceAllocator {

    private int n;

    private ArrayList<Boolean> inds;

    public ServiceAllocator(int n) {

        this.n = n;

        this.inds = new ArrayList<Boolean>();

        for (int i = 0; i < this.n; i++) {

            inds.set(i, false);
        }
    }

    public synchronized int allocate() throws InterruptedException {

        while (!(this.inds.contains(true))) {

            try {

                wait();
            }

            catch (InterruptedException e) {}
        }

        int i = 0;

        while (i < this.n) {

            if (!(this.inds.get(i))) {

                this.inds.set(i, true);
                break;
            }

            i++;
        }

        return i;
    }

    public synchronized void free(int i) {

        this.inds.set(i, false);

        notifyAll();
    }
}
