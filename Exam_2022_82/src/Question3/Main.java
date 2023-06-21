package Question3;

public class Main {

    public static void main(String[] args) {

    }

    public static <T extends Comparable<T>> T smallest(int id, GenTable<T> table1, GenTable<T> table2) {

        T f1 = table1.find(id);
        T f2 = table2.find(id);

        if (f1 == null && f2 == null) {

            return null;
        }

        if (f1 == null) {

            return f2;
        }

        if (f2 == null) {

            return f1;
        }

        if (f1.compareTo(f2) > 0) {

            return f1;
        }

        return f2;
    }
}
