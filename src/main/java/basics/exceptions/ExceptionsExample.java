package basics.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class ExceptionsExample {

    public static final String ERROR_MSG = "You'll never see this!";
    private static final Logger logger = LoggerFactory.getLogger(ExceptionsExample.class.getName());
    private static final int NUMBER_OF_ITERATIONS = 100_000_000;
    int value;

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
        myProfiler.start("Try-catch block with no exception thrown");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            try {
                exceptionsExample.tryCatchWithNoExceptionThrown();
            } catch (Exception e) {
            }
        }

        exceptionsExample.reset();
        myProfiler.start("Create exception without throwing");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            try {
                exceptionsExample.createExceptionWithoutThrowing();
            } catch (Exception e) {
            }
        }

        exceptionsExample.reset();
        myProfiler.start("Create exception and throw it, short stacktrace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            try {
                exceptionsExample.creatingAndThrowingExceptionLevel8();
            } catch (Exception e) {
            }
        }

        myProfiler.start("Create exception and throw it, long stacktrace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            try {
                exceptionsExample.creatingAndThrowingException();
            } catch (Exception e) {
            }
        }

        myProfiler.stop().print();
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        value = 0;
    }

    // Calculates without exception
    public void onlyLogging() {
        value++;
        if (value % 10 == 0) {
            logger.trace(ERROR_MSG);
        }
    }

    // throw exceptions theoretically
    public void tryCatchWithNoExceptionThrown() throws Exception {
        value++;
        if (value % 10 == 0) {
            logger.trace(ERROR_MSG);
        }
        if (value == -1) {
            throw new Exception();
        }
    }

    // create exception object
    public void createExceptionWithoutThrowing() {
        value++;
        if (value % 10 == 0) {
            logger.trace(ERROR_MSG);
            Exception e = new Exception();
        }
    }

    public void creatingAndThrowingException() throws Exception {
        creatingAndThrowingExceptionLevel1();
    }

    public void creatingAndThrowingExceptionLevel1() throws Exception {
        creatingAndThrowingExceptionLevel2();
    }

    public void creatingAndThrowingExceptionLevel2() throws Exception {
        creatingAndThrowingExceptionLevel3();
    }

    public void creatingAndThrowingExceptionLevel3() throws Exception {
        creatingAndThrowingExceptionLevel4();
    }

    public void creatingAndThrowingExceptionLevel4() throws Exception {
        creatingAndThrowingExceptionLevel5();
    }

    public void creatingAndThrowingExceptionLevel5() throws Exception {
        creatingAndThrowingExceptionLevel6();
    }

    public void creatingAndThrowingExceptionLevel6() throws Exception {
        creatingAndThrowingExceptionLevel7();
    }

    public void creatingAndThrowingExceptionLevel7() throws Exception {
        creatingAndThrowingExceptionLevel8();
    }

    // throw exceptions
    public void creatingAndThrowingExceptionLevel8() throws Exception {
        value++;
        if (value % 10 == 0) {
            logger.trace(ERROR_MSG);
            throw new Exception();
        }
    }
}
