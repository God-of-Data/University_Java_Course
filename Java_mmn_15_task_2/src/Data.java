public class Data {

    private int x = 0;

    private int y = 0;

    public Data(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the difference of x,y attributes and prints it.
     *
     * @return The absolute difference of the x,y attributes.
     */
    public int getDiff() {

        int differance = (Math.abs(x - y));

        System.out.println("getDiff: " + this.toString() + " Differance = " + differance);

        return differance;
    }

    /**
     * Adds given delta to x,y attributes and prints the updated object.
     *
     * @param dx delta to be added to x attribute.
     * @param dy delta to be added to y attribute.
     */
    public void update(int dx, int dy) {

        x = x + dx;
        y = y + dy;

        System.out.println("update: " + this.toString());
    }

    @Override
    public String toString() {

        return "Data{" + "x = " + x + ", y = " + y + '}';
    }
}
