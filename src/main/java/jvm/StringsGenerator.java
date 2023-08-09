package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class StringsGenerator {

    private static final Logger logger = LoggerFactory.getLogger(StringsGenerator.class.getName());

    private static final long ITERATIONS = 20_000;

    public static void main(String[] args) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        Profiler myProfiler = new Profiler("StringsGenerator");
        List<String> strings = new ArrayList<>();
        logger.info("Starting");
        myProfiler.start("Generating strings");
        String s = "";
        for (int i = 0; i < ITERATIONS; i++) {
            s += Double.toString(Math.random() * ITERATIONS);
            strings.add(s);
        }
        myProfiler.stop().print();
        logger.trace("Strings={}", strings);
    }
}
