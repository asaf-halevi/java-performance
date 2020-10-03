package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class PhantomRefFinalizerExample {

    private static final Logger logger = LoggerFactory.getLogger(PhantomRefFinalizerExample.class.getName());

    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        List<MyPhantomReference> references = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        //create a students list and maintain a phantom-references list
        for (int i = 0; i < 10; ++i) {
            Student student = new Student(123, "George");
            students.add(student);
            references.add(new MyPhantomReference(student, referenceQueue));
        }

        //delete students list
        students = null;
        System.gc();

        //check if references exist
        Reference<?> referenceFromQueue;
        int i=1;
        for (PhantomReference<Student> reference : references) {
            logger.info("Is reference no.{} in the queue? {}", i, reference.isEnqueued());
            i++;
        }

        //finalize students
        i = 1;
        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            logger.info("Finalizing object no.{}", i);
            i++;
            ((MyPhantomReference)referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }
    }
}
