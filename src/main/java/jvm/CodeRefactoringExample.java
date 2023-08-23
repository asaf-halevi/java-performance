package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

/**
 * check differences when running this code 10K or 10M times
 * The improvements are due to JVM's code refactoring
 */
public class CodeRefactoringExample {

    private static final Logger logger = LoggerFactory.getLogger(CodeRefactoringExample.class.getName());

    private static final long ITERATIONS1 = 1000;//TRY WITH 10_000
    private static final long ITERATIONS2 = ITERATIONS1 * 4;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("CodeRefactoringExample");

        myProfiler.start(ITERATIONS1 + " iterations");
        for (int i = 0; i < ITERATIONS1; i++) {
            doSomething();
        }

        myProfiler.start(ITERATIONS2 + " iterations");
        for (int i = 0; i < ITERATIONS2; i++) {
            doSomething();
        }

        myProfiler.stop().print();
    }

    private static void doSomething() {
        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String b = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String c = a + b;
        logger.trace(c);
    }
}
