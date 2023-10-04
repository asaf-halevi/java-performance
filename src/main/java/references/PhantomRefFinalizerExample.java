package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRefFinalizerExample {

    private static final Logger logger = LoggerFactory.getLogger(PhantomRefFinalizerExample.class.getName());

    public static void main(String[] args) {
        // Create an object
        String someObject = new String("Hello, PhantomReference!");

        // Create a reference queue
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

        // Create a phantom reference to the object and associate it with the reference queue
        PhantomReference<String> phantomReference = new PhantomReference<>(someObject, referenceQueue);

        // Set the object to null, making it eligible for garbage collection
        someObject = null;

        // Poll the reference queue to check if the phantom reference has been enqueued
        while (true) {
            System.gc(); // Request garbage collection (not guaranteed to run immediately)

            // Check if the reference has been enqueued
            PhantomReference<String> enqueuedReference = (PhantomReference<String>) referenceQueue.poll();
            if (enqueuedReference != null) {
                logger.info("Phantom reference is enqueued.");
                // Perform cleanup or resource management here
                // ...
                break; // Exit the loop
            }
        }
    }
}
