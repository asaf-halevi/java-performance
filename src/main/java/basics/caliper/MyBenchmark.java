package basics.caliper;

import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.caliper.api.VmOptions;
import com.google.caliper.runner.CaliperMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@VmOptions("-XX:-TieredCompilation")
public class MyBenchmark {

    private static final Logger logger = LoggerFactory.getLogger(MyBenchmark.class.getName());

    @Param({"a", "b"})
    String s;

    public static void main(String[] args) {
        String[] allArgs = {};
        CaliperMain.main(MyBenchmark.class, allArgs);
    }

    @Benchmark
    private String test(int reps) {
        StringBuilder result = new StringBuilder();
        logger.debug("reps={}", reps);
        for (int i = 0; i < reps; ++i) {
            result.append(i);
            result.append(s);
        }
        return result.toString();
    }
}
