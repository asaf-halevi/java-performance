package garbagecollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalizeExample2 extends AbstractGcExample {
    private static final Logger logger = LoggerFactory.getLogger(FinalizeExample2.class.getName());

    public static void main(String[] args) {
        FinalizeExample2 example = new FinalizeExample2();
        Animal2 lion = example.createAnimal();
        wasteTime();
        logger.debug("An animal was born\n");
        lion = null;
    }

    private Animal2 createAnimal() {
        final String name = "Max";
        return new Animal2(name);
    }
}

class Animal2 {

    private static final Logger logger = LoggerFactory.getLogger(Animal2.class.getName());
    private String name;

    public Animal2(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() {
        logger.debug("an animal called {} died!", name);
    }
}
