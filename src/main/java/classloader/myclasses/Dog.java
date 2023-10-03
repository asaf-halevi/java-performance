package classloader.myclasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dog {

    private static final Logger logger = LoggerFactory.getLogger(Dog.class.getName());

    public void bark() {
        logger.info("woof");
    }
}
