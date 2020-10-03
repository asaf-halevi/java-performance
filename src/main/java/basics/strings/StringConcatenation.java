package basics.strings;

import org.slf4j.profiler.Profiler;

public class StringConcatenation {

    protected static final int NUMBER_OF_ITERATIONS = 10000;// change between 1, 100 & 10000

    private static final int NUMBER_OF_CONCATENATIONS = 300;
    static final String STATIC_TEXT = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    public static void main(String[] args) {
        StringConcatenation stringExamples = new StringConcatenation();
        Profiler myProfiler = new Profiler("StringConcatenation");

        myProfiler.start("naive concatenation");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat1Naive();
        }

        myProfiler.start("use static final");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat2NaiveWithStatic();
        }

        myProfiler.start("use stringBuffer");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat3NaiveWithStringBuffer();
        }

        myProfiler.start("use stringBuilder");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat4NaiveWithStringBuilder();
        }

        myProfiler.start("use stringBuilder with preset size");
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringExamples.concat5NaiveWithStringBuilderWithKnownSize();
        }

        myProfiler.start("no conacatenation");
        for (int i = 0; i < 100000; i++) {
            String a = "aaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbb";
        }

        myProfiler.start("Concat during initialization");
        for (int i = 0; i < 100000; i++) {
            String a = "aaaaaaaaaaaaaaaaa" + "bbbbbbbbbbbbbbbbb";
        }

        myProfiler.stop().print();
    }

    private void concat1Naive() {
        String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result = "";
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result += text;
        }
    }

    private void concat2NaiveWithStatic() {
        String result = "";
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result += STATIC_TEXT;
        }
    }

    private void concat3NaiveWithStringBuffer() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result.append(STATIC_TEXT);
        }
    }

    private void concat4NaiveWithStringBuilder() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result.append(STATIC_TEXT);
        }
    }

    private void concat5NaiveWithStringBuilderWithKnownSize() {
        StringBuilder result = new StringBuilder(STATIC_TEXT.length() * NUMBER_OF_CONCATENATIONS);
        for (int i = 0; i < NUMBER_OF_CONCATENATIONS; i++) {
            result.append(STATIC_TEXT);
        }
    }
}
