package timetracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.text.DecimalFormat;

public class TimeTrackingWithSlf4j {
    private static final Logger logger = LoggerFactory.getLogger(TimeTrackingWithSlf4j.class.getName());
    private static final int NUMBER_OF_ITERATIONS = 10000;
    private static final int NUMBER_OF_CONCATENATIONS = 300;
    private static final String STATIC_TEXT = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private static final DecimalFormat percentageFormat = new DecimalFormat("#.00");

    public static void main(String[] args) {
        TimeTrackingWithSlf4j stringExamples = new TimeTrackingWithSlf4j();
        Profiler myProfiler = new Profiler("TimeTrackingWithSlf4j");

        myProfiler.start("concat1Naive");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat1Naive();
        }

        myProfiler.start("concat2NaiveWithStatic");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat2NaiveWithStatic();
        }

        myProfiler.start("concat3NaiveWithStringBuffer");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat3NaiveWithStringBuffer();
        }

        myProfiler.start("concat4NaiveWithStringBuilder");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat4NaiveWithStringBuilder();
        }
        myProfiler.stop().print();
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
