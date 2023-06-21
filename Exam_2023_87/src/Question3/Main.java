package Question3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        // Use add() method to add elements
        stack.push(10);
        stack.push(15);
        stack.push(30);
        stack.push(20);
        stack.push(5);

        System.out.println(stack);

        Integer num = 15;

        System.out.println(reduceStack(stack, num));

        System.out.println(stack);

    }

    public static <E extends Comparable<E>> E reduceStack(Stack<E> s, E e) {

        if (e == null) {

            return null;
        }

        Stack<E> tmp_s = new Stack<E>();

        E min_e = null;

        while (s.size() > 0) {

            E curr_e = s.pop();


            if (curr_e.compareTo(e) > 0) {

                if (min_e == null) {

                    min_e = curr_e;
                }

                else if (curr_e.compareTo(min_e) < 0) {

                    min_e = curr_e;
                }

            }
            else {

                tmp_s.push(curr_e);
            }
        }

        while (tmp_s.size() > 0) {

            s.push(tmp_s.pop());
        }

        return min_e;
    }

    public static Computable calculate(ArrayList<? extends Computable> arr, Computable e) {

        if (e == null) {

            return null;
        }

        int i = 0;

        while (i < arr.size()) {

            if (arr.get(i).compute() == e.compute()) {

                return arr.get(i);
            }

            i++;
        }

        return null;
    }
}
