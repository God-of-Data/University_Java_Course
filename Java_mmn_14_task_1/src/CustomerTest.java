public class CustomerTest {

    public static void main(String[] args) {

        Queue<Customer> requestQueue = null;

        try {

            requestQueue = new Queue<>(3);
        }

        catch (Exception e) {

            throw new RuntimeException(e);
        }

        Customer customer1 = new Customer("Cat", 12, "Fetch Milk");
        Customer customer2 = new Customer("Tom",12, "Fetch Milk");
        Customer customer3 = new Customer("Jerry", 433, "Fetch Milk");
        Customer customer4 = new Customer("Tom",12, "Say Hi");
        Customer customer5 = new Customer("Tom",852, "Say Bye");
        Customer customer6 = new Customer("Jerry", 12, "Fetch Milk");


        System.out.println("ADD TEST:");

        requestQueue.add(customer1,4);
        requestQueue.add(customer2,1);
        requestQueue.add(customer4,2);
        requestQueue.add(customer5,2);
        requestQueue.add(customer6,3);
        requestQueue.add(customer3,1);


        System.out.println(requestQueue);
        System.out.println();


        System.out.println("ARE REQUESTS EQUAL TEST:");

        System.out.println("customer1 = " + customer1.toString());
        System.out.println("customer2 = " + customer2.toString());
        System.out.println("customer1 == customer2 ? " + customer1.equals(customer2));
        System.out.println("customer3 = " + customer3.toString());
        System.out.println("customer3 == customer2 ? " + customer2.equals(customer3));
        System.out.println();

        System.out.println("POLL 2 TIMES TEST:");
        System.out.println(requestQueue);
        requestQueue.poll();
        requestQueue.poll();
        System.out.println(requestQueue);
        System.out.println();


        System.out.println("REMOVE TEST:");
        System.out.println(requestQueue);
        System.out.println("REMOVE customer1 = " + customer1.toString());
        requestQueue.remove(customer1);
        System.out.println(requestQueue);
        System.out.println("REMOVE AGAIN customer1 = " + customer1.toString());
        requestQueue.remove(customer1);
        System.out.println(requestQueue);
        System.out.println();

        System.out.println("CONTAINS TEST:");
        System.out.println(requestQueue);
        System.out.println("customer1 = " + customer1.toString());
        System.out.println("Is customer1 is in the queue somewhere ? " + requestQueue.contains(customer1));
        System.out.println("customer5 = " + customer5.toString());
        System.out.println("Is customer1 is in the queue somewhere ? " + requestQueue.contains(customer5));
    }
}
