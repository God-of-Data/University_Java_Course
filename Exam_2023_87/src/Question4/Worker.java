package Question4;

public class Worker extends Thread{

    private Manager mon;

    public Worker(Manager mon) {

        this.mon = mon;
    }

    @Override
    public void run() {

        int[] curr_r = mon.allocateRow();

        while (curr_r != null) {

            mon.setSum(sumRow(curr_r));

            curr_r = mon.allocateRow();
        }
    }

    private int sumRow(int[] row) {

        int sum = 0;

        for (int i = 0; i < row.length; i++) {

            sum += row[i];
        }

        return sum;
    }
}
