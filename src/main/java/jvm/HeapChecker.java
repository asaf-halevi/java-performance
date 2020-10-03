package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeapChecker {

    private static final Logger logger = LoggerFactory.getLogger(HeapChecker.class.getName());

    private static final long OUTER_ITERATIONS = 5_000;
    private static final long INNER_ITERATIONS = 1_000_000;

    public static void main (String[] args) {
        logger.info ("Start App");
        for (int i=0; i < OUTER_ITERATIONS; i++){
            logger.info ("Outer iteration no.{}", i+1);
            StringBuilder sb = new StringBuilder ();
            for (int j=0; j < INNER_ITERATIONS; j++){
                sb.append ("Xxxxxxxxxxxxxxxxxxx");
            }
        }
        logger.info ("Finish App");
    }
}
