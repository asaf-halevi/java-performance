package basics.exercise.solutions;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class LogStringsSolution {

    private static final String TEXT_UNIT = "ab";

    private static final Logger logger = LoggerFactory.getLogger(LogStringsSolution.class.getName());

    protected static final int NUMBER_OF_ITERATIONS = 2000;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("LogStringsSolution");
        myProfiler.start("iterate");

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            StringBuilder text = new StringBuilder(TEXT_UNIT.length() * NUMBER_OF_ITERATIONS);
            text.append(TEXT_UNIT);
            for (int j = 0; j < NUMBER_OF_ITERATIONS; j++) {
                logger.trace("i={} j={} text.length={}", i, j, text.length());
                text.append(TEXT_UNIT);
            }
            String result = StringUtils.replace(text.toString(), "b", "a");
            result = StringUtils.replace(result, "a", "x").substring(1, 100);
            logger.debug("{}", result);
        }
        myProfiler.stop().print();
    }
}
