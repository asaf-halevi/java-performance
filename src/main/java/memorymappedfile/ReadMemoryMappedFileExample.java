package memorymappedfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadMemoryMappedFileExample {

    private static final Logger logger = LoggerFactory.getLogger(ReadMemoryMappedFileExample.class.getName());

    private static final String MODE_READ = "r";
    private static final String BIF_FILE_NAME = "src/main/resources/test2.txt";

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile(new File(BIF_FILE_NAME), MODE_READ)) {
            // Get file channel in read-only mode
            FileChannel fileChannel = file.getChannel();
            logger.info("fileChannel.size={} KB", fileChannel.size());

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            // the buffer now reads the file as if it were loaded in memory
            logger.debug("isLoaded={}", buffer.isLoaded()); // prints false
            logger.debug("capacity={}", buffer.capacity()); // Get the size based on content size of file

            // You can read the file from this buffer the way you like.
            for (int i = 0; i < buffer.limit(); i++) {
                logger.trace("content={}", (char) buffer.get()); // Print the content of file
            }
        }
    }
}
