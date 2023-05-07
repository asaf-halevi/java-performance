package classloader.customclassloader;

public class MyClass {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.hello();
    }

    public void hello() {
        System.out.println("Hello world");
    }
}
