package hu.chocolate.machine.data.parse;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public interface DataParser {

    Object parse(List<String> lines);

}