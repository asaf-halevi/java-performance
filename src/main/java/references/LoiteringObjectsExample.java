package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * In this example, we'll see how a simple stack implementation may fill up the memory with loitering objects
 */
public class LoiteringObjectsExample {

    private static final Logger logger = LoggerFactory.getLogger(LoiteringObjectsExample.class.getName());

    private static final int STACK_CAPACITY = 70_000;

    private final List<Student> myStackOfStudents;
    private int topOfStack = 0;

    public LoiteringObjectsExample() {
        myStackOfStudents = new LinkedList<>();
    }

    public boolean isEmpty() {
        return topOfStack == 0;
    }

    public void push(Student student) {
        myStackOfStudents.add(student);
        topOfStack++;
    }

    public Student pop() {
        topOfStack--;

        // the error
        return myStackOfStudents.get(topOfStack);

        //The fix
        //        Student student = myStackOfStudents.get(topOfStack);
        //        Student result = new Student(student);
        //        student = null;
        //        return result;
    }

    public static void main(String[] args) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        LoiteringObjectsExample studentsStack = new LoiteringObjectsExample();
        Scanner scanner = new Scanner(System.in);
        logger.info("Check the heap now.\nEnter some input to begin creation of objects.");
        scanner.nextLine();
        logger.info("{} Students are being pushed into stack", LoiteringObjectsExample.STACK_CAPACITY);

        //fill the stack
        for (int i = 0; i < LoiteringObjectsExample.STACK_CAPACITY; i++) {
            long randomNumber = Math.round(Math.random() * LoiteringObjectsExample.STACK_CAPACITY);
            Student student = new Student(randomNumber, "John" + randomNumber);
            studentsStack.push(student);
        }

        logger.info("all students were pushed.");
        scanner.nextLine();

        //pop from stack
        while (!studentsStack.isEmpty()) {
            logger.info("Student popped from stack: {} ", studentsStack.pop());
        }
        logger.info("Check the Monitor and the number of Student objects in the heap dump now.");
        logger.info("Enter some input to close the application.");
        scanner.nextLine();
        scanner.close();
        logger.info("Check the heap now.\nEnter some input to close app. Check heap again.");
        logger.info("App Closed");
    }
}
