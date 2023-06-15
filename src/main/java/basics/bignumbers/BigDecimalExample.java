package basics.bignumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.math.BigDecimal;

public class BigDecimalExample {

    public static final double NUMBER = 1.01;
    private static final Logger logger = LoggerFactory.getLogger(BigDecimalExample.class.getName());
    private static final int NUMBER_OF_ITERATIONS = 500;

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("BigDecimalExample");

        myProfiler.start("BigDecimal");
        BigDecimal bigDecimal = new BigDecimal(0);
        for (double x = NUMBER; x <= NUMBER_OF_ITERATIONS; x += NUMBER) {
            for (double y = NUMBER; y <= NUMBER_OF_ITERATIONS; y += NUMBER) {
                bigDecimal = BigDecimal.valueOf(x).pow(2).add(BigDecimal.valueOf(y).pow(2)).add(bigDecimal);
            }
        }

        myProfiler.start("double");
        double primitive = 0.0;
        for (double x = NUMBER; x <= NUMBER_OF_ITERATIONS; x += NUMBER) {
            for (double y = NUMBER; y <= NUMBER_OF_ITERATIONS; y += NUMBER) {
                primitive += Math.pow(x, 2) + Math.pow(y, 2);
            }
        }

        myProfiler.stop().print();

        logger.debug("bigDecimal={}", bigDecimal.doubleValue());
        logger.debug("decimal={}", primitive);
        boolean isSameValue = primitive == bigDecimal.doubleValue();
        logger.debug("Did we get the same results? {}!!!", isSameValue);
        double difference = bigDecimal.doubleValue() - primitive;
        logger.debug("Difference is {}", String.format("%.10f", difference));
        logger.debug("Percentage of difference is {}%", String.format("%.20f", difference / (bigDecimal.doubleValue() / 100)));
    }
}
