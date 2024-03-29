package classloader;

public class BasicClassLoaderExample extends ClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                try {
                    if (this.getParent() != null) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = findLoadedClass(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found from the non-null parent class loader
                }
                if (c == null) {
                    // If still not found, then invoke findClass in order to find the class.
                    c = findClass(name);
                }
            }
            if (resolve) {
                //link the class
                resolveClass(c);
            }
            return c;
        }
    }
}
