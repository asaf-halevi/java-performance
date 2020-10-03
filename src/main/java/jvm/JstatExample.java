package jvm;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JstatExample {

    private static final Logger logger = LoggerFactory.getLogger(JstatExample.class.getName());

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
        } while (!inputText.equals("out"));
        scanner.close();
        logger.debug("Thanks!");
    }
}
