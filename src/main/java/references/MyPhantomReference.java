package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MyPhantomReference extends PhantomReference<Student> {

    private static final Logger logger = LoggerFactory.getLogger(MyPhantomReference.class.getName());

    public MyPhantomReference(Student referent, ReferenceQueue<? super Object> q) {
        super(referent, q);
        logger.info("{} added to queue", referent.getName());
    }

    public void finalizeResources() {
        logger.info("Doing some clearing job...");
    }
}
