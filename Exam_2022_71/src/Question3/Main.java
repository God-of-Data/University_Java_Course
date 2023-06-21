package Question3;

import java.util.*;

public class Main {

    public static void main(String[] args) {}

    public static <V, K extends Comparable<K>> HashMap<K,V> grep(HashMap<K,V> h, K k) {

        HashMap<K,V> r = new HashMap<>();

        for(Map.Entry<K,V> e: h.entrySet()) {

            if(e.getKey().compareTo(k) > 0) {

                r.put(e.getKey(), e.getValue());
            }
        }

        return r;
    }
}
