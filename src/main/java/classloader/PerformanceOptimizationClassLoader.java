package classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PerformanceOptimizationClassLoader extends ClassLoader {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceOptimizationClassLoader.class.getName());
    private final Map<String, Class<?>> loadedClasses = new HashMap<>();
    private final String classDir;

    public PerformanceOptimizationClassLoader(String classDir) {
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        if (loadedClasses.containsKey(className)) {
            return loadedClasses.get(className);
        }

        try {
            byte[] classData = loadClassData(className);
            Class<?> clazz = defineClass(className, classData, 0, classData.length);
            loadedClasses.put(className, clazz);
            return clazz;
        } catch (IOException e) {
            throw new ClassNotFoundException("Class not found: " + className, e);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        String classFilePath = classDir + File.separator + className.replace('.', File.separatorChar) + ".class";
        try (InputStream inputStream = Files.newInputStream(Paths.get(classFilePath))) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data;
            while ((data = inputStream.read()) != -1) {
                buffer.write(data);
            }
            return buffer.toByteArray();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Replace 'customClassDir' with the directory containing your custom classes
        final String customClassDir = "/classloader/myclasses";

        PerformanceOptimizationClassLoader customClassLoader = new PerformanceOptimizationClassLoader(customClassDir);

        // Load a class using the custom class loader
        String className = "classloader.myclasses.Dog";
        Class<?> customClass = customClassLoader.loadClass(className);

        // Now you can use 'customClass' and perform operations with it
        logger.info("Loaded class name is {}", customClass.getName());
    }
}
