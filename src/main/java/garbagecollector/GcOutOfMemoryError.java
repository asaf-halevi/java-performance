package garbagecollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.List;

public class GcOutOfMemoryError extends AbstractGcExample {

    private static final Logger logger = LoggerFactory.getLogger(GcOutOfMemoryError.class.getName());

    public static void main(String[] main) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        List<String> l = new LinkedList();
        StringBuilder ll = new StringBuilder("");
        // Enter infinite loop which will add a String to the list: l on each iteration.
        do {
            l.add(new String("Hello, World" + String.valueOf(Math.random())));
            ll.append(l);
        } while (true);
    }
}
