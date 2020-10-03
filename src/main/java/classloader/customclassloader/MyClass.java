package classloader.customclassloader;

public class MyClass {

    public void hello() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.hello();
    }
}
