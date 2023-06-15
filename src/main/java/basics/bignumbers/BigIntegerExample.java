package basics.bignumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.math.BigInteger;

public class BigIntegerExample {

    private static final Logger logger = LoggerFactory.getLogger(BigIntegerExample.class.getName());

    private static final int NUMBER_OF_ITERATIONS = 500;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("BigIntegerExample");

        myProfiler.start("BigInteger");
        BigInteger bigInteger = new BigInteger("0");
        for (int x = 1; x <= NUMBER_OF_ITERATIONS; x++) {
            for (int y = 1; y <= NUMBER_OF_ITERATIONS; y++) {
                bigInteger = BigInteger.valueOf(x).pow(2).add(BigInteger.valueOf(y).pow(2)).add(bigInteger);
            }
        }
        logger.info("BigInteger={}", bigInteger);

        myProfiler.start("long");
        long primitive = 0;
        for (int x = 1; x <= NUMBER_OF_ITERATIONS; x++) {
            for (int y = 1; y <= NUMBER_OF_ITERATIONS; y++) {
                primitive += Math.pow(x, 2) + Math.pow(y, 2);
            }
        }
        logger.info("long={}", primitive);

        myProfiler.stop().print();

        logger.debug("bigInteger={}", bigInteger.longValue());
        logger.debug("long={}", primitive);
        boolean isSameValue = primitive == bigInteger.longValue();
        logger.debug("Did we get the same results? {}", isSameValue);
        logger.debug("Difference is {}", bigInteger.longValue() - primitive);
    }
}
