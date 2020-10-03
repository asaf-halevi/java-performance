package basics.bignumbers;

import org.slf4j.profiler.Profiler;

import java.math.BigDecimal;

public class BigDecimalExample {

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("BigDecimalExample");

        myProfiler.start("BigDecimal");
        BigDecimal bd = new BigDecimal(0);
        for (double x = 0.5; x <= 500; x += 0.5) {
            for (double y = 0.5; y <= 500; y += 0.5) {
                bd = BigDecimal.valueOf(x).pow(2).add(BigDecimal.valueOf(y).pow(2)).add(bd);
            }
        }

        myProfiler.start("double");
        double d = 0;
        for (double x = 0.5; x <= 500; x += 0.5) {
            for (double y = 0.5; y <= 500; y += 0.5) {
                d += Math.pow(x, 2) + Math.pow(y, 2);
            }
        }
        myProfiler.stop().print();
    }
}
