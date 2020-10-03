package classloader.customclassloader;

import java.lang.reflect.Method;

public class CustomClassLoaderExampleTester {

    public static void main(String[] args) {
        CustomClassLoaderExample loader = new CustomClassLoaderExample();
        try {
            Class<?> c = loader.findClass("classloader.customclassloader.MyClass");
            Object obj = c.newInstance();
            Method method = c.getMethod("hello");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
