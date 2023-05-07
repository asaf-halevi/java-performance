package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TooManyObjectInMemoryProblem {

    private static final Logger logger = LoggerFactory.getLogger(TooManyObjectInMemoryProblem.class.getName());

    private static final int ITERATIONS = 100_000;
    private static final String VALUE = "A";

    public static void main(String[] args) {
        List<String> cachedStrings = new ArrayList<>();
        cachedStrings.add(VALUE);
        logger.info("Started");
        for (int i = 1; i < ITERATIONS; i++) {
            cachedStrings.add(cachedStrings.get(i - 1) + VALUE);
        }
        logger.info("Finished");
    }
}
