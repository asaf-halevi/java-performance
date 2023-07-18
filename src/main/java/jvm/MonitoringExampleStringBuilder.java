package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonitoringExampleStringBuilder {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringExampleStringBuilder.class.getName());

    public static void main(String[] args) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        Scanner scanner = new Scanner(System.in);
        StringBuilder tempValue;
        int numOfIterations;
        List<String> totalValues = new ArrayList<>();
        do {
            tempValue = new StringBuilder();
            logger.debug("Numbers of iterations (0 to exit): ");
            numOfIterations = scanner.nextInt();
            long millis = System.currentTimeMillis();
            for (int i = 0; i < numOfIterations; i++) {
                tempValue.append("a");
            }
            totalValues.add(tempValue.toString());
            logger.debug("Time consumed for {} iterations: {} millis", numOfIterations, System.currentTimeMillis() - millis);
        } while (numOfIterations != 0);
        scanner.close();
    }
}
