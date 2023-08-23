package garbagecollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Only when gc is called in row 36 - delete is successful.
 */
public class SystemGcExample {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            someIoJob();
        }
    }

    protected static void someIoJob() throws IOException {
        File tempFile = File.createTempFile("Temp", null);
        tempFile.deleteOnExit();
        RandomAccessFile raTempFile = new RandomAccessFile(tempFile, "rw");
        FileChannel fChannel = raTempFile.getChannel();

        MappedByteBuffer mappedBuffer = fChannel.map(FileChannel.MapMode.READ_WRITE, 0, 512);

        fChannel.close();
        raTempFile.close();
        mappedBuffer = null;

        //Try with and without this row
        //        System.gc();

        if (tempFile.delete()) {
            System.out.println("Successfully deleted: " + tempFile);
        } else {
            System.out.println("Unable to delete: " + tempFile);
        }
    }
}
