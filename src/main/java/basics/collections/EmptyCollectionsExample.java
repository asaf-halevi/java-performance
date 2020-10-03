package basics.collections;

import org.slf4j.profiler.Profiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyCollectionsExample {

    private static final int NUMBER_OF_ITERATIONS = 1_000_000_000;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("EmptyCollectionsExample");
        myProfiler.start("getEmptyCollectionsWithCreation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            getEmptyCollectionsWithCreation();
        }

        myProfiler.start("getEmptyCollectionsWithoutCreation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            getEmptyCollectionsWithoutCreation();
        }
        myProfiler.stop().print();
    }

    private static List<Object> getEmptyCollectionsWithCreation() {
        return new ArrayList<>();
    }

    private static List<Object> getEmptyCollectionsWithoutCreation() {
        return Collections.emptyList();
    }
}
