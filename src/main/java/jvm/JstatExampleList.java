package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JstatExampleList {

    private static final Logger logger = LoggerFactory.getLogger(JstatExampleList.class.getName());

    public static void main(String[] args) {
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        logger.debug("PID={}", processId);
        Scanner scanner = new Scanner(System.in);
        List<String> texts = new ArrayList<>();
        String inputText;
        do {
            logger.debug("Write text ['out' to finish]:");
            inputText = scanner.next();
            texts.add(inputText);
            logger.debug("Number of texts is {}", texts.size());
        } while (!inputText.equals("out"));
        scanner.close();
        logger.debug("Thanks!");
    }
}
