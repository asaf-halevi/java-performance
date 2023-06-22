package basics.singletons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

/**
 * This class demonstrates how the singleton property is broken with reflection,
 * when using private constructors based methods.
 */
public class ReflectionDemo {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionDemo.class.getName());

    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.INSTANCE;

        Constructor constructor = singleton.getClass().getDeclaredConstructor();
        constructor.setAccessible(true); // Make the private constructor accessible

        Singleton singleton2 = (Singleton) constructor.newInstance(); // Create new instance with constructor

        if (singleton == singleton2) {
            logger.debug("Two objects are the same");
        } else {
            logger.debug("Two objects are NOT the same");
        }

        singleton.setValue(1);
        singleton2.setValue(2);

        logger.debug("Value of original is {}. Value of copy is {}.", singleton.getValue(), singleton2.getValue());
    }
}
