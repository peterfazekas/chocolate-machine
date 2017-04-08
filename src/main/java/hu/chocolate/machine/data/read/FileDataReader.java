package hu.chocolate.machine.data.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public class FileDataReader implements DataReader {

    private static final String PATH = "src\\main\\resources\\";

    @Override
    public List<String> read(String source) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + source))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.remove(0);
        return lines;
    }
}
