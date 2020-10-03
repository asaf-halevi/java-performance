package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;

public class SoftRefExample {

    private static final Logger logger = LoggerFactory.getLogger(SoftRefExample.class.getName());

    public static void main(String[] args) {
        // Client gets strong reference
        Student student = new Student(1, "Dan");

        // Cache mechanism gets soft reference
        SoftReference<Student> soft = new SoftReference<>(student);

        // Client release reference when no longer needed
        student = null;

        // Cache keeps on referencing even between GC calls
        System.gc();

        try {
            Thread.yield();
        } catch (Exception e) {
            // Do nothing
        }
        // Other clients may ask for strong references via soft.get() method
        logger.info("Soft={}", soft.get());
    }
}
