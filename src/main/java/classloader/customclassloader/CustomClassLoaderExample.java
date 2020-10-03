package classloader.customclassloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoaderExample extends ClassLoader {

    @Override
    public Class<?> findClass(String className) {
        byte[] data = loadClassData(className);

        // fetch class & load it into the byte array
        return defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        // read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        // write into byte
        int len = 0;
        try {
            while ((len = is.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // convert into byte array
        return byteSt.toByteArray();
    }
}
