package hu.chocolate.machine.data.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public class FileDataLogger implements DataLogger {

    private static final String PATH = "src\\main\\resources\\";
    private static DataLogger instance;
    private final String fileName;

    private FileDataLogger(String fileName) {
        this.fileName = PATH + fileName;
    }

    public static DataLogger createInstance(String fileName) {
        if (null == instance) {
            instance = new FileDataLogger(fileName);
        }
        return instance;
    }

    @Override
    public void println(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
