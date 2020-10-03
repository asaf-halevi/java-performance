package basics.primitives;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class PrimitivesExample {

    private static final Logger logger = LoggerFactory.getLogger(PrimitivesExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 10000;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("PrimitivesExample");

        myProfiler.start("Primitive");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            int a = 1;
        }

        myProfiler.start("Wrapper class");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            Integer a = new Integer(1);
        }
        myProfiler.stop().print();
    }
}
