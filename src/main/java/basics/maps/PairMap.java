package basics.maps;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairMap {
    public static void main(String[] args) {
        Map<Pair<String, String>, String> map = new HashMap<>();
        for (int i = 0; i < 10_000_000; i++) {
            Pair<String, String> key = Pair.of(Integer.toString(i), "A" + Integer.toString(i));
            map.put(key, "a");
        }
        System.out.println("Press any key...");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
