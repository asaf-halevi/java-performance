package classloader.staticexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Airplane extends Vehicle implements Flyable {

    private static final Logger logger = LoggerFactory.getLogger(Airplane.class.getName());

    public Airplane() {
        logger.info("An Airplanes was created");
    }

    public static void main(String[] args) {
        Airplane plane = new Airplane();

        ((Flyable) plane).fly();
    }

    @Override
    public void fly() {
        logger.info("The Airplane flies");
    }

    @Override
    public void canDoSomething() {
        logger.info("something");
    }
}
