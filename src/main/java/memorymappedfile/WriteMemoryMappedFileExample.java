package memorymappedfile;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class WriteMemoryMappedFileExample {

    private static final String BIG_TEXT_FILE = "src/main/resources/test.txt";
    private static final String MODE_READ_WRITE = "rw";

    public static void main(String[] args) throws Exception {
        // Create file object
        File file = new File(BIG_TEXT_FILE);

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, MODE_READ_WRITE)) {
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, (4096 * 8 * 8L));

            // Write the content using put methods
            buffer.put("bla bla".getBytes());
        }
    }
}
