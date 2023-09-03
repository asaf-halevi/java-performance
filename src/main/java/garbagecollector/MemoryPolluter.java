package garbagecollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Run with different GC settings:
 * Serial: -XX:+UseSerialGC
 * Parallel: -XX:+UseParallelGC -XX:ParallelGCThreads=6
 * CMS: nothing... it's Java 8's default
 * G1: -XX:+UseG1GC -XX:+UseStringDeduplication
 * <p>
 * Try again. but this time do not save to the list (comment out line 44)
 */
public class MemoryPolluter {

    private static final Logger logger = LoggerFactory.getLogger(MemoryPolluter.class.getName());
    private static final int ITERATION_COUNT = 200_000;


    public static void main(String[] args) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        Scanner scanner = new Scanner(System.in);
        logger.debug("Press any key to start");
        scanner.next();
        scanner.close();
        List<String> totalValues = new ArrayList<>();
        StringBuilder tempValue;
        Profiler profiler = new Profiler("main");
        profiler.start("entire code");
        for (int j = 0; j < 1_000; j++) {
            logger.debug("{}", j + 1);
            tempValue = new StringBuilder();
            for (int i = 0; i < ITERATION_COUNT; i++) {
                tempValue.append("abcdefg" + Math.random());
            }
            totalValues.add(tempValue.toString());
        }
        profiler.stop().print();
    }
}
