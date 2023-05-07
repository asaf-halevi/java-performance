package classloader.staticexample;

public class Airplane extends Vehicle implements Flyable {

    public Airplane() {
        System.out.println("An Airplanes was created");
    }

    public static void main(String[] args) {
        Airplane plane = new Airplane();

        ((Flyable) plane).fly();
    }

    @Override
    public void fly() {
        System.out.println("The Airplane flies");
    }

    @Override
    public void canDoSomething() {
    }
}
