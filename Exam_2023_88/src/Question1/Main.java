package Question1;

public class Main {

    public static void main(String[] args) {

        Worker w = new TypeB() {

            public void action() throws Exception {

                System.out.println("action");

                throw new Exception("Exception");

            }

            public void actionA() {

                System.out.println("actionA");
            }

            public void actionB() {

                System.out.println("actionB");
            }
        };
    }
}
