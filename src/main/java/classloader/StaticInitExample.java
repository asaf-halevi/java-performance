package classloader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ah864q
 *
 */
public class StaticInitExample {

    private static final Logger logger = LoggerFactory.getLogger(StaticInitExample.class.getName());

    public static double myRandom(String text) {
        logger.debug("myRandom called with {}", text);
        return Math.random();
    }

    public static String myTextEditor (String text){
        logger.debug("myTextEditor called with {}", text);
        return StringUtils.replace(text, "d", "Z");
    }

    public static void main(String[] args) {
        //Change the order of static calls with -verbose
        double resultOfMyRandom = StaticInitExample.myRandom("xyz");
        String resultOfMyConcat = StaticInitExample.myTextEditor("abddf");

        logger.info("Result of calling myRandom is {}", resultOfMyRandom);
        logger.info("Result of calling myTextEditor is {}", resultOfMyConcat);
    }
}
