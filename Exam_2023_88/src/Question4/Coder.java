package Question4;

public class Coder extends Thread{

    private Storage s;

    public Coder(Storage s) {

        this.s = s;
    }

    public String encode(String s) {

        return new StringBuffer(s).reverse().toString();
    }

    public void run() {

        super.run();

        Data d = this.s.getData();

        while (d != null) {

            String result = encode(d.getText());

            s.setData(new Data(d.getPos(), result));
        }
    }
}
