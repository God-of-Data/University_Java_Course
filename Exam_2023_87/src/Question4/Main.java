package Question4;

import java.util.*;

public class Main {

    private static final int W_SIZE = 10;
    private static final int M_SIZE = 100;

    public static void main(String[] args) {

        int[][] m = new int[M_SIZE][M_SIZE];

        Random rnd = new Random();

        for (int i = 0; i < M_SIZE; i++) {

            for (int j = 0; j < M_SIZE; j++) {

                m[i][j] = (rnd.nextInt() % 1000) + 1;
            }
        }

        Manager mon = new Manager(m);

        Worker[] w_arr = new Worker[W_SIZE];

        for (int i = 0; i < W_SIZE; i++) {

            w_arr[i] = new Worker(mon);
        }
        for (int i = 0; i < W_SIZE; i++) {

            w_arr[i].start();
        }

        System.out.println(mon.getTotal());
    }
}
