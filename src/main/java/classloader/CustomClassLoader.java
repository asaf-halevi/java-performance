package classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * A custom class loader that extends the default class loader and loads a byte array from the specified file
 */
public class CustomClassLoader extends ClassLoader {

    private static final Logger logger = LoggerFactory.getLogger(CustomClassLoader.class.getName());

    @Override
    public Class findClass(String name) {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue;
        try {
            if (inputStream != null) {
                while ((nextValue = inputStream.read()) != -1) {
                    byteStream.write(nextValue);
                }
            }
        } catch (IOException e) {
            logger.error("{}", e.getMessage(), e);
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}
