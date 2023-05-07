package timetracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeTrackingWithLogger {

    private static final Logger logger = LoggerFactory.getLogger(TimeTrackingWithLogger.class.getName());

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        doSomeThing();
        long timeConsumed = System.nanoTime() - startTime;
        logger.info("Time Consumed = {}", timeConsumed);
    }

    private static void doSomeThing() {
        String s = "*";
        for (int i = 0; i < 100_000; i++) {
            s = s + "*";
        }
    }
}
