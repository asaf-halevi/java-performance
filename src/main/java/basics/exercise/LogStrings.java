package basics.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class LogStrings {

    protected static final int NUMBER_OF_ITERATIONS = 2000;
    private static final Logger logger = LoggerFactory.getLogger(LogStrings.class.getName());
    private static final String TEXT_UNIT = "abc";

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("LogStrings");
        myProfiler.start("iterate");

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            String text = TEXT_UNIT;
            for (int j = 0; j < NUMBER_OF_ITERATIONS; j++) {
                logger.trace("i=" + i + " j=" + j + " text.length=" + text.length());
                text += TEXT_UNIT;
            }
            text = text.replace("b", "a");
            text = text.replace("c", "x");
            logger.debug("{}", text.substring(1, 100));
        }
        myProfiler.stop().print();
    }
}
