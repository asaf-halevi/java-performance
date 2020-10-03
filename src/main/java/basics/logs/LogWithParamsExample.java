package basics.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class LogWithParamsExample {

    private static final Logger logger = LoggerFactory.getLogger(LogWithParamsExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 20000;

    public static void main(String[] args) {

        Profiler myProfiler = new Profiler("LogWithParamsExample");

        myProfiler.start("debug");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.debug("The number is " + i);
        }

        myProfiler.start("debug written properly");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.debug("The number is {}", i);
        }

        myProfiler.start("trace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.trace("The number is " + i);
        }

        myProfiler.start("isTraceEnabled");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            if (logger.isTraceEnabled()) {
                logger.trace("The number is " + i);
            }
        }

        myProfiler.start("log level is trace, and written properly");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.trace("The number is {}", i);
        }
        myProfiler.stop().print();
    }
}
