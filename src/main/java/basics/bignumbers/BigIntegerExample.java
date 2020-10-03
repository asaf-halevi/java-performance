package basics.bignumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.math.BigInteger;

public class BigIntegerExample {

    private static final Logger logger = LoggerFactory.getLogger(BigIntegerExample.class.getName());

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("BigIntegerExample");

        myProfiler.start("BigInteger");
        BigInteger bi = new BigInteger("0");
        for (int x = 1; x <= 500; x++) {
            for (int y = 1; y <= 500; y++) {
                bi = BigInteger.valueOf(x).pow(2).add(BigInteger.valueOf(y).pow(2)).add(bi);
            }
        }
        logger.info("BigInteger={}", bi);

        myProfiler.start("long");
        long l = 0;
        for (int x = 1; x <= 500; x++) {
            for (int y = 1; y <= 500; y++) {
                l += Math.pow(x, 2) + Math.pow(y, 2);
            }
        }
        logger.info("long={}", l);
        myProfiler.stop().print();
    }
}
