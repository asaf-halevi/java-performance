package basics.singletons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class demonstrates how the singleton property is broken with deserialization,
 * when using private constructors based methods.
 *
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
            logger.debug("Two objects are same");
        } else {
            logger.debug("Two objects are not same");
        }

        logger.debug("{}", singleton.getValue());
        logger.debug("{}", singleton2.getValue());
    }
}
