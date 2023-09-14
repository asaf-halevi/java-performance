package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftRefExample {

    private static final Logger logger = LoggerFactory.getLogger(SoftRefExample.class.getName());

    public static void main(String[] args) {
        SoftRefExample example = new SoftRefExample();
        example.testReference(false);
        logger.debug("\n\n");
        example.testReference(true);
    }

    public void testReference(boolean isSoftRef) {
        Reference<Student> studentRef;
        if (isSoftRef) {
            studentRef = getSoftReference(new Student(1, "Softy"));
        } else {
            studentRef = getWeakReference(new Student(2, "Weaky"));
        }
        logger.debug("Data from ref before gc: {}", studentRef.get());
        System.gc();
        logger.debug("-------gc called ---------");

        logger.debug("Data from ref after gc: {}", studentRef.get());
    }

    private SoftReference<Student> getSoftReference(Student student) {
        return new SoftReference<>(student);
    }

    private WeakReference<Student> getWeakReference(Student student) {
        return new WeakReference<>(student);
    }
}
