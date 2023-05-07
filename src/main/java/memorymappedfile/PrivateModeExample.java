package memorymappedfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class PrivateModeExample {

    private static final Logger logger = LoggerFactory.getLogger(PrivateModeExample.class.getName());

    private static final String OUTPUT_FILE = "src/main/resources/bigFile2.txt";

    public static void main(String[] args) throws Exception {
        PrivateModeExample privateModeExample = new PrivateModeExample();
        privateModeExample.writeMemoryMappedFile("ABC");
    }

    public File writeMemoryMappedFile(String text) throws IOException {
        // Create file object
        File file = new File(OUTPUT_FILE);
        file.delete();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {// FILE MUST BE OPENED FOR READ/WRITE !!!
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.PRIVATE, 0,
                    text.length());// MODE IS PRIVATE !!! CHECK OUTPUT WITH PRIVATE & READ_WRITE MODES !!!
            // fileChannel.unmap(); //NOTE THAT THERE IS NO fileChannel.unmap(); !!!

            // Write the content using put methods
            buffer.put(text.getBytes());
            fileChannel.close();
            logger.debug("File size according to private buffer after closing fileChannel is {}", buffer.capacity());
        }
        return file;
    }
}
