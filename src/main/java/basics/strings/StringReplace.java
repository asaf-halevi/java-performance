package basics.strings;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.profiler.Profiler;

public class StringReplace {

    protected static final int NUMBER_OF_ITERATIONS = 10000;// change between 1, 100 & 10000

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("StringReplace");
        String text = "aaaaaaaaaaaaaaaaaaaaaaa";

        myProfiler.start("String.replace");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            text.replace("a", "b");
            text.replace("b", "a");
        }

        myProfiler.start("StringUtils.replac");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            StringUtils.replace(text, "a", "b");
            StringUtils.replace(text, "b", "a");
        }

        myProfiler.stop().print();
    }
}
