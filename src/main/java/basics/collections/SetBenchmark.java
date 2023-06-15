package basics.collections;

import org.slf4j.profiler.Profiler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetBenchmark {

    protected static final int NUMBER_OF_ITERATIONS = 100_000;

    public static void main(String[] args) {
        SetBenchmark setBenchmark = new SetBenchmark();

        Set<Employee> hashSet = new HashSet<>();
        setBenchmark.testSet(hashSet, "HashSet");

        Set<Employee> hashSetPredefined = new HashSet<>(NUMBER_OF_ITERATIONS);
        setBenchmark.testSet(hashSet, "HashSet with predefined size");

        Set<Employee> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        setBenchmark.testSet(copyOnWriteArraySet, "CopyOnWriteArraySet");
    }

    public void testSet(Set<Employee> employeeSet, String setTypeName) {
        Profiler myProfiler = new Profiler(setTypeName + " Benchmark");

        myProfiler.start("buildSet " + setTypeName);
        buildSet(employeeSet);

        myProfiler.start("removeFromSet " + setTypeName);
        removeFromSet(employeeSet);

        myProfiler.stop().print();
    }

    public void buildSet(Set<Employee> employeeSet) {
        Employee e;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            e = new Employee((NUMBER_OF_ITERATIONS * Math.round(Math.random())), "John");
            employeeSet.add(e);
        }
    }

    private void removeFromSet(Set<Employee> employeeSet) {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            employeeSet.remove(0);
        }
    }
}
