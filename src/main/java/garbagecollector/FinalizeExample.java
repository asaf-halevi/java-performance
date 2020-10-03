package garbagecollector;

public class FinalizeExample extends AbstractGcExample {

    public static void main(String[] args) {
        FinalizeExample example = new FinalizeExample();
        example.createAnimal();
        wasteTime();
        System.out.println("An animal was created\n");
    }

    private void createAnimal() {
        final String name = "Max";
        Animal lion = new Animal(name);
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() {
        System.out.println(this.name + " is dead!\n");
    }
}
