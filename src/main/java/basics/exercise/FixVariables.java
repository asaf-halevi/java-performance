package basics.exercise;

import org.slf4j.profiler.Profiler;

public class FixVariables {

    protected static final int NUMBER_OF_ITERATIONS = 10000000;

    private static Long num = 0L;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("FixVariables");
        myProfiler.start("iterate");

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            num += i;
        }
        myProfiler.stop().print();
    }
}
