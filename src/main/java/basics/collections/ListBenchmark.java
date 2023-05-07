package basics.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListBenchmark {

    protected static final int NUMBER_OF_ITERATIONS = 100000;
    private static final Logger logger = LoggerFactory.getLogger(ListBenchmark.class.getName());

    public static void main(String[] args) {
        ListBenchmark listBenchmark = new ListBenchmark();

        List employeeArrayList = new ArrayList();
        listBenchmark.testList(employeeArrayList, "ArrayList");

        List employeeLinkedList = new LinkedList();
        listBenchmark.testList(employeeLinkedList, "LinkedList");

        List copyOnWriteArrayList = new CopyOnWriteArrayList<Employee>();
        listBenchmark.testList(copyOnWriteArrayList, "CopyOnWriteArrayList");
    }

    public void testList(List employeeList, String listTypeName) {
        Profiler myProfiler = new Profiler(listTypeName + " Benchmark");

        myProfiler.start("buildList " + listTypeName);
        buildList(employeeList);

        myProfiler.start("readFromList " + listTypeName);
        readFromList(employeeList);

        myProfiler.start("removeFromList " + listTypeName);
        removeFromList(employeeList);

        myProfiler.stop().print();
    }

    public void buildList(List<Employee> employeeList) {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            employeeList.add(new Employee((i), "John"));
        }
    }

    private void readFromList(List employeeList) {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            employeeList.get(i);
        }
    }

    private void removeFromList(List employeeList) {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            employeeList.remove(0);
        }
    }
}
