package basics.collections;

import org.slf4j.profiler.Profiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyCollectionsExample {

    private static final int NUMBER_OF_ITERATIONS = 10_000_000;

    public static void main(String[] args) {
        List<List<Object>> myList1 = new ArrayList<>(NUMBER_OF_ITERATIONS);
        List<List<Object>> myList2 = new ArrayList<>(NUMBER_OF_ITERATIONS);

        Profiler myProfiler = new Profiler("EmptyCollectionsExample");
        myProfiler.start("getEmptyCollectionsWithCreation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            myList1.add(new ArrayList<>());
        }

        myProfiler.start("getEmptyCollectionsWithoutCreation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            myList2.add(Collections.emptyList());
        }

        myProfiler.stop().print();


        myList1.get(0).add(new Object());
        //        myList2.get(0).add(new Object()); //throws UnsupportedOperationException
    }
}
