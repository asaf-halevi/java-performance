package basics.singletons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This class demonstrates how the singleton property is broken with deserialization,
 * when using private constructors based methods.
 */
public class SerializeDemo implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(SerializeDemo.class.getName());

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setValue(1);

        // Serialize the singleton with value = 1
        try {
            FileOutputStream fileOut = new FileOutputStream("out.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(singleton);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singleton.setValue(2); // Change the value of the singleton in memory to 2

        // Deserialize the serialized singleton with value 1
        Singleton singleton2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("out.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singleton2 = (Singleton) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            logger.debug("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }

        if (singleton == singleton2) {
            logger.debug("Two objects are the same");
        } else {
            logger.debug("Two objects are NOT the same");
        }

        logger.debug("Value of original is {}. Value of copy is {}.", singleton.getValue(), singleton2.getValue());
    }
}
