package Question4;

import java.util.*;

public class Monitor {

    private int n;

    private int count = 0;
    private Stack<Integer> inds;


    public Monitor(int n) {

        this.n = n;

        for (int i = 0; i < this.n; i++) {

            this.inds.push(i);
        }
    }

    public synchronized int allocate() throws InterruptedException {

        while (inds.isEmpty()) {

            try {

                wait();
            }
            catch (InterruptedException e) {}
        }

        count++;

        notifyAll();

        return inds.pop();
    }

    public synchronized void free(int i) {

        this.inds.push(i);

        notifyAll();
    }

    public synchronized void waitCount(int x) {

        while (this.count < x) {

            try {

                wait();
            }
            catch (InterruptedException e) {}
        }
    }
}
