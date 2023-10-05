package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

    private static final Logger logger = LoggerFactory.getLogger(WeakHashMapExample.class.getName());

    public static void main(String[] args) {
        Map<Integer, Student> students = new WeakHashMap<>();
        Student student = new Student(1, "Mark");
        Integer key = 1234;
        students.put(key, student);

        logger.info("Map before GC: {}", students);

        System.gc();

        logger.info("Map after first GC: {}", students);

        key = null;

        logger.info("Map after key is set to null: {}", students);

        System.gc();

        logger.info("Map after second GC: {}", students); // empty
    }
}
