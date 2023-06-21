package Question4;

public class Allocator extends Thread {

    private Monitor m;

    private Resource[] r;

    private boolean done = false;

    public Allocator(Monitor m, Resource[] r) {

        this.m = m;
        this.r = r;
    }

    @Override
    public void run() {

        super.run();

        for (int i = 0; i < this.r.length; i++) {

            try {

                int x = m.allocate();

                int calc = this.r[x].calculate();

                System.out.println(calc);

                m.free(x);

            } catch (InterruptedException e) { }

            if (this.done) {

                stop();
            }
        }

    }

    public void finish() {

        this.done = true;
    }

}
