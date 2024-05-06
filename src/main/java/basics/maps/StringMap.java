package basics.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10_000_000; i++) {
            String key = Integer.toString(i) + "_A" + Integer.toString(i);
            map.put(key, "a");
        }
        System.out.println("Press any key...");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
