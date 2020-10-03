package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRefExample {

    private static final Logger logger = LoggerFactory.getLogger(PhantomRefExample.class.getName());

    public static void main(String[] args) {

        // Client gets strong reference
        Student student = new Student(1, "Dan");

        // Creating a phantom reference & registering it in a queue
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Student> phantom = new PhantomReference<>(student, queue);

        logger.info("phantom when object has a strong reference={}", queue.poll());

        // Client release reference when no longer needed
        student = null;
        logger.info("phantom when object has no reference={}", queue.poll());

        // Reference is added to the queue after obj is finalized, but before its memory reclaimed
        System.gc();
        logger.info("GC called");
        try {
            Thread.yield();
        } catch (Exception e) {
            // Do nothing
        }

        logger.info("phantom after Thread.yield={}", queue.poll());
    }
}
