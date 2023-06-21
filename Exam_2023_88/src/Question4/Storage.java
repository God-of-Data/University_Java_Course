package Question4;

import java.util.*;
public class Storage {

    private String[] texts;

    private boolean[] textEncryptedInd;

    private int done = 0;

    private int size = 0;

    public Storage(String [] texts) {

        this.size = texts.length;

        this.texts = new String[size];

        this.textEncryptedInd = new boolean[size];

        for(int i = 0; i < this.size; i++) {

            this.texts[i] = texts[i];

            this.textEncryptedInd[i] = false;
        }
    }

    public synchronized Data getData() {

        Data d = null;

        for (int i = 0; i < this.texts.length; i++) {

            if (!(this.textEncryptedInd[i])) {

                d = new Data(i, this.texts[i]);

                return d;
            }
        }

        return d;
    }

    public synchronized void setData(Data d) {

        int i = d.getPos();

        this.texts[i] = d.getText();

        this.textEncryptedInd[i] = true;

        done++;

        notifyAll();
    }

    public synchronized String[] getResult() {

        while (this.done < this.size) {

            try {

                wait();
            }

            catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

        return this.texts;
    }
}
