package garbagecollector;

import java.util.LinkedList;
import java.util.List;

public class GcOutOfMemoryError extends AbstractGcExample {

    public static void main(String[] main) {
        List<String> l = new LinkedList();
        StringBuilder ll = new StringBuilder("");
        // Enter infinite loop which will add a String to the list: l on each iteration.
        do {
            l.add(new String("Hello, World" + String.valueOf(Math.random())));
            ll.append(l);
        } while (true);
    }
}
