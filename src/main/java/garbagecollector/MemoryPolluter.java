package garbagecollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class MemoryPolluter {

    private static final Logger logger = LoggerFactory.getLogger(MemoryPolluter.class.getName());

    private static final int MEGABYTE_IN_BYTES = 1024 * 1024;
    private static final int ITERATION_COUNT = 102_400;
    private static final int NUMBER_OF_CHECKS = 5;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("MemoryPolluter");
        for (int numberOfCheck = 1; numberOfCheck <= NUMBER_OF_CHECKS; numberOfCheck++) {
            myProfiler.start("Starting pollution check no. " + numberOfCheck);
            logger.info("Starting pollution, check no. {}", numberOfCheck);
            for (int i = 0; i < ITERATION_COUNT; i++) {
                byte[] array = new byte[MEGABYTE_IN_BYTES];
                logger.debug("{}", array.length);
            }
            logger.info("Terminating check no. {}", numberOfCheck);
        }
        myProfiler.stop().print();
    }
}
