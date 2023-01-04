import java.util.HashMap;
import java.util.Map;

public class Jenerics {


    public <E extends Comparable<E>, T> Map<E, T> grep(Map<E, T>  hashVar, E valKey) {


        Map<E, T> copy = new HashMap<>();

        for (E key: hashVar.keySet()) {

            if(key.compareTo(valKey) > 0) {

                copy.put(key, hashVar.get(key));
            }

        }

        return copy;

    }
}
