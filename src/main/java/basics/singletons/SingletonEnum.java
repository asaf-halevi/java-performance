package basics.singletons;

/**
 * The best method for creating singletons in java.
 * Singleton property is 100% guaranteed.
 *
 * @author Dulaj Atapattu
 */
public enum SingletonEnum {
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
