package basics.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class LogWithParamsExample {

    private static final Logger logger = LoggerFactory.getLogger(LogWithParamsExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 10_000;

    public static void main(String[] args) {

        Profiler myProfiler = new Profiler("LogWithParamsExample");

        myProfiler.start("debug written wrong");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.debug("The number is " + Math.random());
        }

        myProfiler.start("debug written properly");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.debug("The number is {}", Math.random());
        }

        myProfiler.start("trace written wrong");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.trace("The number is " + Math.random());
        }

        myProfiler.start("trace written properly");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.trace("The number is {}", Math.random());
        }

        myProfiler.start("isTraceEnabled and written wrong");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            if (logger.isTraceEnabled()) {
                logger.trace("The number is " + Math.random());
            }
        }

        // will be beneficial once we change log level to trace
        myProfiler.start("isTraceEnabled and written properly");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.trace("The number is {}", Math.random());
        }
        
        myProfiler.stop().print();
    }
}
