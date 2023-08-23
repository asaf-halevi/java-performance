package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StringDeduplicationExample {

    public static final String ENTER_TEXT = "Enter text: ";
    private static final Logger logger = LoggerFactory.getLogger(StringDeduplicationExample.class.getName());
    private static Scanner scanner;

    public static void main(String[] args) {// -XX:+UseG1GC -XX:+UseStringDeduplication
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
        logger.debug(ENTER_TEXT);
        String first = scanner.next();
        logger.debug(ENTER_TEXT);
        String sameAsFirst = scanner.next();
        logger.debug("String from scanner are equal={}", first == sameAsFirst);
    }

    private static void checkNonLiteralStringWithIntern() {
        logger.debug(ENTER_TEXT);
        String first = scanner.next().intern();
        logger.debug(ENTER_TEXT);
        String sameAsFirst = scanner.next().intern();
        logger.debug("String from scanner after intern are equal={}", first == sameAsFirst);
    }
}
