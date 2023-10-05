package references;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The mainStudentsList is the source of truth that should hold strong references.
 * The onlyJohns is a sublist that shouldn't hold information once it was removed from the main list.
 */
public class WeakRefListExample {

    private static final Logger logger = LoggerFactory.getLogger(WeakRefListExample.class.getName());

    public static void main(String[] args) {
        strongReferenceRun();
        System.out.println("\n-------------\n");
        weakReferenceRun();
    }

    private static void strongReferenceRun() {
        logger.info("Creating main students list");
        List<Student> mainStudentsList = new ArrayList<>();
        mainStudentsList.add(new Student(1, "John"));
        mainStudentsList.add(new Student(2, "Jack"));
        mainStudentsList.add(new Student(3, "George"));

        logger.info("Creating a sub list");
        List<Student> onlyJohns = mainStudentsList.stream()
                .filter(student -> student.getName().equals("John"))
                .collect(Collectors.toList());

        logger.info("Sublist first value: {}", onlyJohns.get(0));

        logger.info("Calling GC");
        System.gc();

        logger.info("Sublist first value: {}", onlyJohns.get(0));

        logger.info("Removing a student from main list");
        mainStudentsList.clear();

        logger.info("Calling GC");
        System.gc();

        logger.info("Sublist first value: {} ", onlyJohns.get(0));

    }

    private static void weakReferenceRun() {
        logger.info("Creating main students list");
        List<Student> mainStudentsList = new ArrayList<>();
        mainStudentsList.add(new Student(1, "John"));
        mainStudentsList.add(new Student(2, "Jack"));
        mainStudentsList.add(new Student(3, "George"));

        logger.info("Creating a sub list");

        List<WeakReference<Student>> onlyJohns = new ArrayList<>();
        mainStudentsList.forEach(student -> {
            if (student.getName().equals("John")) {
                onlyJohns.add(new WeakReference<>(student));
            }
        });

        logger.info("Sublist first value: {} ", onlyJohns.get(0).get());

        logger.info("Calling GC");
        System.gc();

        logger.info("Sublist first value: {} ", onlyJohns.get(0).get());

        logger.info("Removing a student from main list");
        mainStudentsList.clear();

        logger.info("Calling GC");
        System.gc();

        logger.info("Sublist first value: {} ", onlyJohns.get(0).get());
    }
}
