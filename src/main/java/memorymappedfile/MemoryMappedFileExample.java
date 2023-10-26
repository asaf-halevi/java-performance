package memorymappedfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * create a large file
 */
public class MemoryMappedFileExample {

    private static final Logger logger = LoggerFactory.getLogger(MemoryMappedFileExample.class.getName());

    private static final String INPUT_FILE = "src/main/resources/test2.txt";
    private static final String OUTPUT_FILE = "src/main/resources/bigFile2.txt";


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        MemoryMappedFileExample memoryMappedFileExample = new MemoryMappedFileExample();
        Profiler myProfiler = new Profiler("MemoryMappedFileExample");

        // check memory with visualVM here
        logger.info("get text from regular file: ");
        scanner.next();
        myProfiler.start("get text from regular file");
        String result = memoryMappedFileExample.getTextFromFile(INPUT_FILE);
        logger.debug("Number of bytes read from file is {}", result.length());

        // check memory with visualVM here - we need to free the memory
        logger.info("write MMF: ");
        scanner.next();
        myProfiler.start("write MMF");
        File file = memoryMappedFileExample.writeMemoryMappedFile(result);
        result = null;
        System.gc();

        // check memory with visualVM here
        logger.info("read MMF: ");
        scanner.next();
        myProfiler.start("read MMF");
        memoryMappedFileExample.readMemoryMappedFile(file);

        myProfiler.stop().print();
        scanner.close();
    }

    protected static String getFormattedNumber(long num) {
        return NumberFormat.getNumberInstance(Locale.US).format(num);
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

    public File writeMemoryMappedFile(String text) throws IOException {
        // Create file object
        File file = new File(OUTPUT_FILE);
        file.delete();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, text.length());

            // Write the content using put methods
            buffer.put(text.getBytes());
        }
        return file;
    }

    public void readMemoryMappedFile(File file) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            // Get file channel in read-only mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            // the buffer now reads the file as if it were loaded in memory.
            logger.debug("file size={} bytes", getFormattedNumber(buffer.capacity())); // Get the size based on content size of file

            StringBuilder text = new StringBuilder();
            // You can read the file from this buffer the way you like.
            for (int i = 0; i < buffer.limit(); i++) {
                text.append((char) buffer.get());
            }
        }
    }
}
