package jvm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringDeduplicationExample {

    private static final Logger logger = LoggerFactory.getLogger(StringDeduplicationExample.class.getName());

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        checkLiteralString();
        checkNonLiteralStringWithoutIntern();
        checkNonLiteralStringWithIntern();
        scanner.close();
    }

    protected static void checkLiteralString() {
        String first = "cat";
        String sameAsFirst = "cat";
        logger.debug("Literal String are equal={}", first == sameAsFirst);
        String sameSameButDifferent = new String("cat");
        logger.debug("Existing and new strings are equal={}", first == sameSameButDifferent);
    }

    private static void checkNonLiteralStringWithoutIntern() {
        System.out.print("Enter text: ");
        String first = scanner.next();
        System.out.print("Enter text: ");
        String sameAsFirst = scanner.next();
        logger.debug("String from scanner are equal={}", first == sameAsFirst);
    }

    private static void checkNonLiteralStringWithIntern() {
        System.out.print("Enter text: ");
        String first = scanner.next().intern();
        System.out.print("Enter text: ");
        String sameAsFirst = scanner.next().intern();
        logger.debug("String from scanner after intern are equal={}", first == sameAsFirst);
    }
}
