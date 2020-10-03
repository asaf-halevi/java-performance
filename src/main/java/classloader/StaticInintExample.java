package classloader;

public class StaticInintExample {

    private static double a = Math.random();
    private static double b;
    static {
        b = Math.random();
    }
    private static double c = Math.random();

    public static void main(String[] args) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
    }
}
