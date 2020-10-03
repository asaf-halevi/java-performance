package garbagecollector;

public abstract class AbstractGcExample {

    protected static void wasteTime() {
        String a = "";
        for (long i = 0; i < 5000; i++) {
            a += String.valueOf(i);
        }
    }
}
