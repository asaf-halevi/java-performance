package basics.primitives;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class PrimitivesExample {

    private static final Logger logger = LoggerFactory.getLogger(PrimitivesExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 10_000;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("PrimitivesExample");

        myProfiler.start("int");
        int primitiveInt = 0;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            primitiveInt++;
        }
        logger.trace("primitiveInt={}", primitiveInt);

        myProfiler.start("Integer");
        Integer wrapperInt = 0;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            wrapperInt++;
        }
        logger.trace("wrapperInt={}", wrapperInt);

        myProfiler.start("double");
        double primitiveDouble = 0.0;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            primitiveDouble += 0.1;
        }
        logger.trace("primitiveDouble={}", primitiveDouble);

        myProfiler.start("Double");
        Double wrapperDouble = 0.0;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            wrapperDouble += 0.1;
        }
        logger.trace("wrapperDouble={}", wrapperDouble);

        myProfiler.start("boolean");
        boolean primitiveBoolean = true;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            primitiveBoolean = !primitiveBoolean;
        }
        logger.trace("primitiveBoolean={}", primitiveBoolean);

        myProfiler.start("Boolean");
        Boolean wrapperBoolean = true;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            wrapperBoolean = !wrapperBoolean;
        }
        logger.trace("wrapperBoolean={}", wrapperBoolean);

        myProfiler.stop().print();
    }
}
