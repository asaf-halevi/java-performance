package basics.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class LogNumOfCallsExample {

    private static final Logger logger = LoggerFactory.getLogger(LogNumOfCallsExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 10000;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("LogNumOfCallsExample");

        myProfiler.start("debug");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.debug("msg1");
        }


        myProfiler.start("trace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            logger.trace("msg2");
        }
        myProfiler.stop().print();
    }
}
