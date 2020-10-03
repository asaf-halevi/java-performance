package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class TooManyObjectInMemorySolution {

    private static final Logger logger = LoggerFactory.getLogger(TooManyObjectInMemorySolution.class.getName());

    private static final int ITERATIONS = 100_000;
    private static final String VALUE = "A";

    public static void main(String[] args) {
        List<SoftReference<String>> strings = new ArrayList<>();
        strings.add(new SoftReference<>(VALUE));
        logger.info("Started");
        for (int i=1; i < ITERATIONS; i++){
            strings.add(new SoftReference<>(strings.get(i - 1).get() + VALUE));
        }
        logger.info("Finished");
        logger.info("Strings size = {}", strings.size());
        long numberOfNonNullStrings = strings
                .stream()
                .filter(n -> n.get() != null)
                .count();
        logger.info("Number of non-null Strings = {}", numberOfNonNullStrings);
    }
}
