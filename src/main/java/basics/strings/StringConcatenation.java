package basics.strings;

import org.slf4j.profiler.Profiler;

public class StringConcatenation {

    protected static final int NUMBER_OF_ITERATIONS = 40_000;
    private static final String STATIC_TEXT = "hello";

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("StringConcatenation");

        myProfiler.start("naive concatenation");
        String naive = "";
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            naive += "hello";
        }

        myProfiler.start("naive concatenation with static");
        String naiveWithStatic = "";
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            naiveWithStatic += STATIC_TEXT;
        }

        myProfiler.start("use stringBuffer");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuffer.append(STATIC_TEXT);
        }

        myProfiler.start("use stringBuilder");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuilder.append(STATIC_TEXT);
        }

        myProfiler.start("use stringBuilder with preset size");
        StringBuilder stringBuilderPresetSize = new StringBuilder(STATIC_TEXT.length() * NUMBER_OF_ITERATIONS);
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuilderPresetSize.append(STATIC_TEXT);
        }

        myProfiler.start("no concatenation");
        String noConcat;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            noConcat = "helloWorld";
        }

        myProfiler.start("Concat during initialization");
        String concatOnInit;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            concatOnInit = "hello" + "World";
        }

        myProfiler.stop().print();
    }
}
