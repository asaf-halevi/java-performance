package basics.singletons;

import java.io.Serializable;

public class Singleton implements Serializable {

    public static final Singleton INSTANCE = new Singleton();
    private static final long serialVersionUID = 1L;
    private int value = 0;

    private Singleton() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
