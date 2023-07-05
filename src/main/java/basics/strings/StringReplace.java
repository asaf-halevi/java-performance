package basics.strings;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.profiler.Profiler;

public class StringReplace {

    protected static final int NUMBER_OF_ITERATIONS = 10_000;// change between 1, 100 & 100_000

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("StringReplace");
        String text = "aaaaaaaaaaaaaaaaaaaaaaa";

        myProfiler.start("String.replace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            text = text.replace("a", "b");
            text = text.replace("b", "a");
        }

        myProfiler.start("StringUtils.replace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            text = StringUtils.replace(text, "a", "b");
            text = StringUtils.replace(text, "b", "a");
        }

        myProfiler.stop().print();
    }
}
