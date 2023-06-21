package Question4;

public class Manager {

    int[][] m;
    boolean[] inds;
    int n = 0;
    int sum = 0;
    int done = 0;

    public Manager(int[][] m) {

        this.m = m;
        this.n = this.m.length;
        this.inds = new boolean[this.n];

        for (int i = 0; i < this.inds.length; i++) {

            this.inds[i] = false;
        }
    }

    public synchronized int[] allocateRow() {

        for (int i = 0; i < this.inds.length; i++) {

            if (!(this.inds[i])) {

                this.inds[i] = true;

                return this.m[i];
            }
        }

        return null;
    }

    public synchronized void setSum(int sum) {

        this.sum += sum;

        this.done++;

        if (this.done == this.n) {

            notifyAll();
        }
    }

    public int getTotal() {

        while (this.done < this.n) {

            try {

                wait();
            }

            catch (InterruptedException e) {

            }
        }

        return this.sum;
    }
}
