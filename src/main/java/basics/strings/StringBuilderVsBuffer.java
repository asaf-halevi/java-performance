package basics.strings;

import org.slf4j.profiler.Profiler;

public class StringBuilderVsBuffer {

    protected static final int NUMBER_OF_ITERATIONS = 10_000_000;
    private static final String STATIC_TEXT1 = "Hello ";
    private static final String STATIC_TEXT2 = "World ";

    public static void main(String[] args) {
        Profiler myProfiler = new Profiler("StringBuilderVsBuffer");

        myProfiler.start("StringBuffer");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuffer.append(STATIC_TEXT1);
            stringBuffer.append(STATIC_TEXT2);
        }

        myProfiler.start("StringBuilder with preset size");
        StringBuffer stringBuffer2 = new StringBuffer((STATIC_TEXT1 + STATIC_TEXT2).length() * NUMBER_OF_ITERATIONS);
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuffer2.append(STATIC_TEXT1);
            stringBuffer2.append(STATIC_TEXT2);
        }

        myProfiler.start("StringBuilder");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuilder.append(STATIC_TEXT1);
            stringBuilder.append(STATIC_TEXT2);
        }

        myProfiler.start("StringBuilder with preset size");
        StringBuilder stringBuilder2 = new StringBuilder((STATIC_TEXT1 + STATIC_TEXT2).length() * NUMBER_OF_ITERATIONS);
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            stringBuilder2.append(STATIC_TEXT1);
            stringBuilder2.append(STATIC_TEXT2);
        }

        myProfiler.stop().print();
    }
}
