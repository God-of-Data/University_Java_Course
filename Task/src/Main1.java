
class Main1 {

    public static void main(String[] args) {
        FF f = new FF() {

            public void bar() {

                System.out.print("bar anonymous");
            }
        };


//        f.foo();
        f.bar();
    }
}