import java.util.Iterator;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> queue = null;

        try {

            queue = new Queue<>(3);
        }

        catch (Exception e) {

            throw new RuntimeException(e);
        }


        //add is working
        //System.out.println("ADD");
        System.out.println("ADD TEST:");

        queue.add("One-Go", 1);
        queue.add("Two-Bye", 2);
        queue.add("Three-Set", 3);
        queue.add("Four-Let", 3);
        queue.add("Five-Hello", 2);
        queue.add("Six-Hi", 1);
        queue.add("Last", 4);

        System.out.println(queue);
        System.out.println();


        System.out.println("POLL 3 TIMES TEST:");
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue);
        System.out.println();


        System.out.println("ADD 2 NEW ITEMS TEST:");
        queue.add("Seven", 1);
        queue.add("Eight", 1);
        System.out.println(queue);
        System.out.println();

        System.out.println("CONTAINS TEST:");
        System.out.println(queue);
        System.out.println("One-Go is already in the queue somewhere? " + queue.contains("One"));
        System.out.println("Three-Set is already in the queue somewhere? " + queue.contains("Three-Set"));
        System.out.println();


        System.out.println("REMOVE TEST: remove Four-Let");
        queue.remove("Four-Let");
        System.out.println(queue);
        System.out.println();

        System.out.println("SIZE TEST: ");
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println();


        System.out.println("ITERATOR TEST: ");

        Iterator itr = queue.iterator();

        while (itr.hasNext()) {

            System.out.println(itr.next());
        }
    }
}


