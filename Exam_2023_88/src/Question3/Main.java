package Question3;
import java.util.*;

public class Main {

    public static <E extends Shape> String getBiggest(HashMap<String,E> hm) {

        Map.Entry<String,E> e = null;

        for(Map.Entry<String,E> entry: hm.entrySet()) {

            if(e == null) {

                e = entry;
            }

            else if(entry.getValue().getArea() > e.getValue().getArea()) {

                e = entry;
            }
        }

        return e.getKey();
    }

    public static String nonGenericGetBiggest(HashMap<String,? extends Shape> hm){

        Map.Entry<String,? extends Shape> e = null;

        for(Map.Entry<String,? extends Shape> entry: hm.entrySet()){

            if(e == null) {

                e = entry;
            }

            else if(entry.getValue().getArea() > e.getValue().getArea()) {

                e = entry;
            }
        }

        return e.getKey();
    }

    public static void main(String[] args) {

    }
}

