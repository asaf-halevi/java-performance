package basics.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class IntegerMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10_000_000; i++) {
            MyKey key = new MyKey(Integer.toString(i), Integer.toString(i));
            map.put(key.hashCode(), "a");
        }
        System.out.println("Press any key...");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    static class MyKey {
        private String left;
        private String right;

        public MyKey(String left, String right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {return true;}
            if (!(o instanceof MyKey)) {return false;}
            MyKey myKey = (MyKey) o;
            return Objects.equals(left, myKey.left) && Objects.equals(right, myKey.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
