package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftRefExample {

    private static final Logger logger = LoggerFactory.getLogger(SoftRefExample.class.getName());

    public static void main(String[] args) {
        Reference<Student> studentRef;

        studentRef = getWeakReference(new Student(1, "Weakling"));
        logResults(studentRef);

        System.out.println("\n---------------\n");

        studentRef = getSoftReference(new Student(2, "Softy"));
        logResults(studentRef);
    }

    private static void logResults(Reference<Student> studentRef) {
        logger.debug("Data from ref before gc: {}", studentRef.get());
        System.gc();
        logger.debug("-------gc called ---------");
        logger.debug("Data from ref after gc: {}", studentRef.get());
    }

    private static SoftReference<Student> getSoftReference(Student student) {
        return new SoftReference<>(student);
    }

    private static WeakReference<Student> getWeakReference(Student student) {
        return new WeakReference<>(student);
    }
}
