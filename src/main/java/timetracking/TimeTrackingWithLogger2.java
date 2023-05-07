package timetracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

public class TimeTrackingWithLogger2 {

    private static final Logger logger = LoggerFactory.getLogger(TimeTrackingWithLogger2.class.getName());
    private static final int NUMBER_OF_ITERATIONS = 10000;
    private static final int NUMBER_OF_CONCATENATIONS = 300;
    private static final String STATIC_TEXT = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private static final DecimalFormat percentageFormat = new DecimalFormat("#.00");

    public static void main(String[] args) {
        TimeTrackingWithLogger2 stringExamples = new TimeTrackingWithLogger2();

        // naive concatenation
        long start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat1Naive();
        }
        long finish1 = System.nanoTime() - start;
        printResults("concatNaive1\t\t", finish1, finish1);

        // use static final
        start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat2NaiveWithStatic();
        }
        long finish2 = System.nanoTime() - start;
        printResults("concatNaiveWithStatic2\t", finish2, finish1);

        // use stringBuffer
        start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat3NaiveWithStringBuffer();
        }
        long finish3 = System.nanoTime() - start;
        printResults("concat3NaiveWithStringBuffer", finish3, finish2);

        // use stringBuilder
        start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat4NaiveWithStringBuilder();
        }
        long finish4 = System.nanoTime() - start;
        printResults("concat4NaiveWithStringBuilder", finish4, finish3);
    }

    protected static void printResults(String methodName, long finishCurrent, long finishPrevious) {
        logger.debug("Time consumed by {}\t{} seconds", methodName, (float) (finishCurrent / 10_000_000) / 100);
    }

    private void concat1Naive() {
        String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result = "";
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result += text;
        }
    }

    private void concat2NaiveWithStatic() {
        String result = "";
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result += STATIC_TEXT;
        }
    }

    private void concat3NaiveWithStringBuffer() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result.append(STATIC_TEXT);
        }
    }

    private void concat4NaiveWithStringBuilder() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result.append(STATIC_TEXT);
        }
    }
}
