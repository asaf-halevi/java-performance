package basics.singletons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides an demonstration of how to use singletons with enums.
 */
public class EnumDemo {

    private static final Logger logger = LoggerFactory.getLogger(EnumDemo.class.getName());

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;

        logger.debug("Value before change: {}", singleton.getValue());
        singleton.setValue(2);
        logger.debug("Value after change: {}", singleton.getValue());
    }
}
