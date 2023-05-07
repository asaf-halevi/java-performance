package classloader;

public class StaticInintExample {

    private static double a = Math.random();
    private static double b;
    private static double c = Math.random();

    static {
        b = Math.random();
    }

    public static void main(String[] args) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
    }
}
