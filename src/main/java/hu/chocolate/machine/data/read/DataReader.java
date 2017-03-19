package hu.chocolate.machine.data.read;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public interface DataReader {

    List<String> read(final String source);
}
