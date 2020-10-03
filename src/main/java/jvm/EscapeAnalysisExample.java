package jvm;

/**
 * In this example, two objects are created, and one of them is given as an argument to a method of another.
 * The method setCar() stores a reference to a received Car object.
 * If the Person object was on the heap then the reference to Car would escape.
 * But in this case a compiler can determine, with escape analysis, that the Person object itself does not escape the invocation of example().
 * Which implies that a reference to Car cannot escape either. So the compiler can safely allocate both objects on the stack.
 *
 * @author ah864q
 *
 */
public class EscapeAnalysisExample {
    public static void main(String[] args) {
        example();
    }

    public static void example() {
        Car car = new Car();
        Person john = new Person();
        john.setCar(car);
    }
}

class Car {
}

class Person {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }
}
