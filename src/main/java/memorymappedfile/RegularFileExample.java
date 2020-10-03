package memorymappedfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class RegularFileExample {

    private static final Logger logger = LoggerFactory.getLogger(RegularFileExample.class.getName());

    private static final String INPUT_FILE = "src/main/resources/bigFile.txt";
    private static final String OUTPUT_FILE = "src/main/resources/bigFile2.txt";

    public static void main(String[] args) throws IOException {
        RegularFileExample regularFileExample = new RegularFileExample();
        Profiler myProfiler = new Profiler("RegularFileExample");

        // check memory with visualVM here
        myProfiler.start("read");
        String result = regularFileExample.getTextFromFile(INPUT_FILE);

        // check memory with visualVM here - if we don't save data in file - huge amounts of memory will be used!
        myProfiler.start("write");
        regularFileExample.saveTextIntoFile(result);
        result = null;
        System.gc();

        myProfiler.stop().print();
    }

    public String getTextFromFile(String fileName) throws IOException {
        File file = new File(fileName);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

        StringBuilder allDataAsText = new StringBuilder();
        String line;
        try {
            while (br != null && (line = br.readLine()) != null) {
                allDataAsText.append(line).append(" ");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return allDataAsText.toString();
    }

    private void saveTextIntoFile(String text) throws IOException {
        File f = new File(OUTPUT_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            writer.append(text);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    protected static String getTime(long time) {
        return NumberFormat.getNumberInstance(Locale.US).format(time);
    }
}
