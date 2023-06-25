package basics.strings;

import org.slf4j.profiler.Profiler;

public class StringConcatenation {

    protected static final int NUMBER_OF_ITERATIONS = 7_000;
    private static final String STATIC_TEXT = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private static final int NUMBER_OF_CONCATENATIONS = 300;

    public static void main(String[] args) {
        StringConcatenation stringExamples = new StringConcatenation();
        Profiler myProfiler = new Profiler("StringConcatenation");

        myProfiler.start("naive concatenation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            String result = "";
            for (int j = 0; j < NUMBER_OF_CONCATENATIONS; j++) {
                result += text;
            }
        }

        myProfiler.start("naive concatenation with static");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            String result = "";
            for (int j = 0; j < NUMBER_OF_CONCATENATIONS; j++) {
                result += STATIC_TEXT;
            }
        }

        myProfiler.start("use stringBuffer");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            StringBuffer result = new StringBuffer();
            for (int j = 0; j < NUMBER_OF_CONCATENATIONS; j++) {
                result.append(STATIC_TEXT);
            }
        }

        myProfiler.start("use stringBuilder");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < NUMBER_OF_CONCATENATIONS; j++) {
                result.append(STATIC_TEXT);
            }
        }

        myProfiler.start("use stringBuilder with preset size");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            StringBuilder result = new StringBuilder(STATIC_TEXT.length() * NUMBER_OF_CONCATENATIONS);
            for (int j = 0; j < NUMBER_OF_CONCATENATIONS; j++) {
                result.append(STATIC_TEXT);
            }
        }

        myProfiler.start("no concatenation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            String a = "aaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbb";
        }

        myProfiler.start("Concat during initialization");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            String a = "aaaaaaaaaaaaaaaaa" + "bbbbbbbbbbbbbbbbb";
        }

        myProfiler.stop().print();
    }
}
