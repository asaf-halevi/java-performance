package memorymappedfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class StudentsMMF {

    public static final char CHAR_TO_FIND = 'J';
    private static final Logger logger = LoggerFactory.getLogger(StudentsMMF.class.getName());
    private static final String INPUT_FILE = "src/main/resources/bigFile.txt";
    private static final String MODE_READ = "r";

    public static void main(String[] args) throws Exception {
        Profiler myProfiler = new Profiler("MemoryMappedFileExample");

        long count = 0;
        try (RandomAccessFile file = new RandomAccessFile(new File(INPUT_FILE), MODE_READ)) {
            FileChannel fileChannel = file.getChannel();

            myProfiler.start("map MMF file");
            myProfiler.start("Look for char in MMF file");
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            char singleChar;
            for (int i = 0; i < buffer.limit(); i++) {
                singleChar = (char) buffer.get();
                if (singleChar == CHAR_TO_FIND) {
                    count++;
                }
            }
        }
        logger.info("Occurrences of J in MMF = {}", count);

        myProfiler.start("Look for char in text file");
        File file = new File(INPUT_FILE);
        count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == CHAR_TO_FIND) {
                        count++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        logger.info("Occurrences of J in File = {}", count);

        myProfiler.stop().print();
    }
}
