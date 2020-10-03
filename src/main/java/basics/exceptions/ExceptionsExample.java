package basics.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class ExceptionsExample {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionsExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 100000000;

    int value;

    public int getValue() {
        return value;
    }

    public void reset() {
        value = 0;
    }

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("ExceptionsExample");
        ExceptionsExample exceptionsExample = new ExceptionsExample();

        // onlyLogging - only log
        exceptionsExample.reset();
        myProfiler.start("Only Logging");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            exceptionsExample.onlyLogging();
        }

        exceptionsExample.reset();
        myProfiler.start("Exception is never thrown");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            try {
                exceptionsExample.tryCatchWithNoExceptionThrown();
            } catch (Exception e) {
            }
        }

        exceptionsExample.reset();
        myProfiler.start("Create exception without throwing it, and log");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            exceptionsExample.createExceptionWithoutThrowing();
        }

        // creatingAndThrowingException - throw exception and log
        exceptionsExample.reset();
        myProfiler.start("Throw exception and log");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            try {
                exceptionsExample.creatingAndThrowingException();
            } catch (Exception e) {
            }
        }
        myProfiler.stop().print();
    }

    // Calculates without exception
    public void onlyLogging() {
        value++;
        if (value % 10 == 0) {
            logger.trace("You'll never see this!");
        }
    }

    // throw exceptions theoretically
    public void tryCatchWithNoExceptionThrown() throws Exception {
        value++;
        if (value % 10 == 0) {
            logger.trace("You'll never see this!");
        }
        if (value == -1) {
            throw new Exception();
        }
    }

    // create exception object
    public void createExceptionWithoutThrowing() {
        value++;
        if (value % 10 == 0) {
            logger.trace("You'll never see this!");
            Exception e = new Exception();
        }
    }

    // throw exceptions
    public void creatingAndThrowingException() throws Exception {
        value++;
        if (value % 10 == 0) {
            logger.trace("You'll never see this!");
            throw new Exception();
        }
    }
}
