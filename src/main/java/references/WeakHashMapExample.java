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

        logger.info("Does object exist before GC? {}", students.containsKey(1234)); //true

        System.gc();

        logger.info("Does object exist after first GC? {}", students.containsKey(1234));//true

        key = null;

        logger.info("Does object exist after key is set to null? {}", students.containsKey(1234));//true

        System.gc();

        logger.info("Does object exist after second GC? {}", students.containsKey(1234));//false
    }
}
