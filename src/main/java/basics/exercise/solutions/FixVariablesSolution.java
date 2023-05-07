package basics.exercise.solutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class FixVariablesSolution {

    protected static final int NUMBER_OF_ITERATIONS = 10000000;
    private static final Logger logger = LoggerFactory.getLogger(FixVariablesSolution.class.getName());

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("FixVariablesSolution");
        myProfiler.start("iterate");
        long num = 0L;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            num += i;
        }
        myProfiler.stop().print();
    }
}
