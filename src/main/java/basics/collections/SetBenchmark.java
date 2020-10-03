package basics.collections;

import org.slf4j.profiler.Profiler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetBenchmark {

    protected static final int NUMBER_OF_ITERATIONS = 100000;

    public static void main(String[] args) {
        SetBenchmark setBenchmark = new SetBenchmark();

        Set hashSet = new HashSet<Employee>();
        setBenchmark.testSet(hashSet, "HashSet");

        Set copyOnWriteArraySet = new CopyOnWriteArraySet<Employee>();
        setBenchmark.testSet(copyOnWriteArraySet, "CopyOnWriteArraySet");
    }

    public void testSet(Set employeeSet, String setTypeName) {
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

    private void removeFromSet(Set employeeSet) {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            employeeSet.remove(0);
        }
    }
}
