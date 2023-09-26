package classloader.customclassloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

    private static final Logger logger = LoggerFactory.getLogger(MyClass.class.getName());

    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.hello();
    }

    public void hello() {
        logger.debug("Hello world");
    }
}
