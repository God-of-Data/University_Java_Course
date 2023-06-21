package Question3;

public class GenTable <T> implements GenLookup<T> {

    T[] objs;

    int[] keys;

    Exception IllegalSizeException = new Exception("IllegalSizeException");



    public GenTable(int[] keys, T[] objs) throws Exception {

        this.keys = keys;
        this.objs = objs;

        if (this.keys.length != this.objs.length) {

            throw IllegalSizeException;
        }
    }

    public T find(Integer key) {

        for (int i = 0; i < this.keys.length; i++) {

            if (key.equals(this.keys[i])) {

                return this.objs[i];
            }
        }

        return null;
    }
}
