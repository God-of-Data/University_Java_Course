
public class Customer {
    private String name;

    private String request;

    private int idNumber;



    public Customer(String name, int id, String request) {


        this.name = name;
        this.idNumber = id;
        this.request = request;
    }

    public void setRequest(String request) {

        this.request = request;
    }

    public String getRequest() {

        return this.request;

    }

    public int getIdNumber() {

        return this.idNumber;
    }

//    public void addRequest(String request, int priority) {
//
//        requestQueue.add(request, priority);
//    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }

        if (!(obj instanceof Customer)) {

            return false;
        }

        Customer customer = (Customer) obj;


        boolean customerRequestsAreEqual
                = (this.getIdNumber() == customer.getIdNumber()) && this.getRequest().equals(customer.getRequest());

        return customerRequestsAreEqual;
    }

    @Override
    public String toString() {

        return "Customer{" + idNumber + "," + name + ",\"" + request + "\"}";
    }
}