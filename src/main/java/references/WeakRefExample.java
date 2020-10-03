package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.WeakReference;

public class WeakRefExample {

    private static final Logger logger = LoggerFactory.getLogger(WeakRefExample.class.getName());

    public static void main(String[] args) {
        // Client gets strong reference
        Student student = new Student(1, "Dan");

        // Cache mechanism gets weak reference
        WeakReference<Student> weak = new WeakReference<>(student);

        // Client release reference when no longer needed
        student = null;

        logger.info("Weak before GC={}", weak.get());

        // Containers get rid from weak refs when no strong reference exist
        System.gc();

        try {
            Thread.yield();
        } catch (Exception e) {
            // Do nothing
        }

        /*
         * Other clients may ask for strong references via weak.get() method.
         * If the object is still alive, a strong reference is returned.
         * If the object was garbage-collected, a null value is returned.
         */
        logger.info("Weak after GC={}", weak.get());
    }
}
