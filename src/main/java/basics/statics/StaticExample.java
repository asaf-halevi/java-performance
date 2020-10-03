package basics.statics;

import org.slf4j.profiler.Profiler;

public class StaticExample {

    private static final int NUMBER_OF_ITERATIONS = 100_000;
    private static long staticVar = 0;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("StaticExample");

        myProfiler.start("static");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            staticVar += 1;
        }

        myProfiler.start("local");
        long localVar = 0;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            localVar += 1;
        }
        myProfiler.stop().print();
    }
}
