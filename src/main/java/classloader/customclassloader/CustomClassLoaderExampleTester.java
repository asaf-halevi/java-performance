package classloader.customclassloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class CustomClassLoaderExampleTester {

    private static final Logger logger = LoggerFactory.getLogger(CustomClassLoaderExampleTester.class.getName());

    public static void main(String[] args) {
        CustomClassLoaderExample loader = new CustomClassLoaderExample();
        try {
            Class<?> c = loader.findClass("classloader.customclassloader.MyClass");
            Object obj = c.getDeclaredConstructor().newInstance();
            Method method = c.getMethod("hello");
            method.invoke(obj);
        } catch (Exception e) {
            logger.error("{}", e.getMessage(), e);
        }
    }
}
