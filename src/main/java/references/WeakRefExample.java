package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WeakRefExample {

    private static final Logger logger = LoggerFactory.getLogger(WeakRefExample.class.getName());

    private static final int STACK_CAPACITY = 100_000;

    private final List<WeakReference<Student>> myStackOfStudents;
    private int topOfStack = 0;

    public WeakRefExample() {
        myStackOfStudents = new LinkedList<>();
    }

    public static void main(String[] args) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        WeakRefExample studentsStack = new WeakRefExample();
        Scanner scanner = new Scanner(System.in);
        logger.info("Check the heap now.\nEnter some input to begin creation of objects.");
        scanner.nextLine();
        logger.info("{} Students are being pushed into stack", WeakRefExample.STACK_CAPACITY);

        //fill the stack
        for (int i = 0; i < WeakRefExample.STACK_CAPACITY; i++) {
            long randomNumber = Math.round(Math.random() * WeakRefExample.STACK_CAPACITY);
            Student student = new Student(randomNumber, "John" + randomNumber);
            studentsStack.push(student);
        }

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

    public void push(Student student) {
        // !!!!!!!!!!! Here's the magic !!!!!!!!
        WeakReference<Student> studentWeakRef = new WeakReference<>(student);
        myStackOfStudents.add(studentWeakRef);
        topOfStack++;
    }

    public Student pop() {
        topOfStack--;
        return myStackOfStudents.get(topOfStack).get(); //return strong reference
    }

    public boolean isEmpty() {
        return topOfStack == 0;
    }
}
