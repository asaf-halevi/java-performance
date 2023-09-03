package garbagecollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalizeExample extends AbstractGcExample {
    private static final Logger logger = LoggerFactory.getLogger(FinalizeExample.class.getName());

    public static void main(String[] args) {
        FinalizeExample example = new FinalizeExample();
        example.createAnimal();
        wasteTime();
        logger.debug("An animal was born");
    }

    private void createAnimal() {
        final String name = "Max";
        new Animal(name);
    }
}

class Animal {

    private static final Logger logger = LoggerFactory.getLogger(Animal.class.getName());
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() {
        logger.debug("an animal called {} died!", name);
    }
}
